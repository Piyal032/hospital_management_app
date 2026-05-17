package com.hospital.management.data.repository

import com.hospital.management.data.local.DoctorDao
import com.hospital.management.data.model.Doctor
import com.hospital.management.data.remote.ApiService
import com.hospital.management.util.DummyDataProvider
import com.hospital.management.util.NetworkUtils
import com.hospital.management.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DoctorRepository @Inject constructor(
    private val apiService: ApiService,
    private val doctorDao: DoctorDao,
    private val networkUtils: NetworkUtils,
    private val dummyDataProvider: DummyDataProvider
) {
    fun getDoctors(): Flow<Resource<List<Doctor>>> = flow {
        emit(Resource.Loading())

        try {
            if (networkUtils.isNetworkAvailable()) {
                val response = apiService.getDoctors()
                if (response.isSuccessful && response.body()?.success == true) {
                    val doctors = response.body()?.data ?: emptyList()
                    doctorDao.insertDoctors(doctors)
                    emit(Resource.Success(doctors))
                    return@flow
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error("API Error: ${e.message}"))
        }

        try {
            val doctors = doctorDao.getAllDoctors().first()
            if (doctors.isNotEmpty()) {
                emit(Resource.Success(doctors, isFromCache = true))
                return@flow
            }
        } catch (e: Exception) { }

        val dummyDoctors = dummyDataProvider.getDummyDoctors()
        doctorDao.insertDoctors(dummyDoctors)
        emit(Resource.Success(dummyDoctors, isFromCache = true))
    }

    fun getDoctorsBySpecialization(specialization: String): Flow<Resource<List<Doctor>>> = flow {
        emit(Resource.Loading())
        try {
            doctorDao.getDoctorsBySpecialization(specialization).collect { doctors ->
                emit(Resource.Success(doctors))
            }
        } catch (e: Exception) {
            val filtered = dummyDataProvider.getDummyDoctors().filter {
                it.specialization == specialization
            }
            emit(Resource.Success(filtered, isFromCache = true))
        }
    }
}
