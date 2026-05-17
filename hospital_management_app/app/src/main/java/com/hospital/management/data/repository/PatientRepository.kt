package com.hospital.management.data.repository

import com.hospital.management.data.local.PatientDao
import com.hospital.management.data.model.Patient
import com.hospital.management.data.remote.ApiService
import com.hospital.management.util.DummyDataProvider
import com.hospital.management.util.NetworkUtils
import com.hospital.management.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PatientRepository @Inject constructor(
    private val apiService: ApiService,
    private val patientDao: PatientDao,
    private val networkUtils: NetworkUtils,
    private val dummyDataProvider: DummyDataProvider
) {
    fun getPatients(): Flow<Resource<List<Patient>>> = flow {
        emit(Resource.Loading())

        try {
            // Step 1: API try karo
            if (networkUtils.isNetworkAvailable()) {
                val response = apiService.getPatients()
                if (response.isSuccessful && response.body()?.success == true) {
                    val patients = response.body()?.data ?: emptyList()
                    patientDao.insertPatients(patients)
                    emit(Resource.Success(patients))
                    return@flow
                }
            }
        } catch (e: HttpException) {
            emit(Resource.Error("Server error: ${e.message}"))
        } catch (e: IOException) {
            emit(Resource.Error("Network error: ${e.message}"))
        } catch (e: Exception) {
            emit(Resource.Error("Unexpected error: ${e.message}"))
        }

        // Step 2: API fail hui → Room DB se lo
        try {
            val patients = patientDao.getAllPatients().first()
            if (patients.isNotEmpty()) {
                emit(Resource.Success(patients, isFromCache = true))
                return@flow
            }
        } catch (e: Exception) {
            // Room bhi fail
        }

        // Step 3: Room bhi empty → Dummy JSON se lo
        val dummyPatients = dummyDataProvider.getDummyPatients()
        patientDao.insertPatients(dummyPatients)
        emit(Resource.Success(dummyPatients, isFromCache = true))
    }

    fun searchPatients(query: String): Flow<Resource<List<Patient>>> = flow {
        emit(Resource.Loading())
        try {
            patientDao.searchPatients(query).collect { patients ->
                if (patients.isNotEmpty()) {
                    emit(Resource.Success(patients))
                } else {
                    val filtered = dummyDataProvider.getDummyPatients().filter {
                        it.name.contains(query, ignoreCase = true) ||
                        it.phone.contains(query, ignoreCase = true)
                    }
                    emit(Resource.Success(filtered, isFromCache = true))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error("Search failed: ${e.message}"))
        }
    }

    suspend fun getPatientById(patientId: String): Resource<Patient> {
        return try {
            val patient = patientDao.getPatientById(patientId)
            if (patient != null) {
                Resource.Success(patient)
            } else {
                val dummy = dummyDataProvider.getDummyPatients().find { it.id == patientId }
                if (dummy != null) {
                    Resource.Success(dummy, isFromCache = true)
                } else {
                    Resource.Error("Patient not found")
                }
            }
        } catch (e: Exception) {
            Resource.Error("Error: ${e.message}")
        }
    }
}
