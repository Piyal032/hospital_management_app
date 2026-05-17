package com.hospital.management.di

import android.content.Context
import androidx.room.Room
import com.hospital.management.data.local.*
import com.hospital.management.data.remote.ApiService
import com.hospital.management.data.remote.RetrofitClient
import com.hospital.management.util.DummyDataProvider
import com.hospital.management.util.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): RetrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun provideApiService(retrofitClient: RetrofitClient): ApiService = retrofitClient.apiService

    @Provides
    @Singleton
    fun provideHospitalDatabase(@ApplicationContext context: Context): HospitalDatabase {
        return Room.databaseBuilder(
            context,
            HospitalDatabase::class.java,
            "hospital_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePatientDao(database: HospitalDatabase): PatientDao = database.patientDao()

    @Provides
    @Singleton
    fun provideDoctorDao(database: HospitalDatabase): DoctorDao = database.doctorDao()

    @Provides
    @Singleton
    fun provideAppointmentDao(database: HospitalDatabase): AppointmentDao = database.appointmentDao()

    @Provides
    @Singleton
    fun providePrescriptionDao(database: HospitalDatabase): PrescriptionDao = database.prescriptionDao()

    @Provides
    @Singleton
    fun provideMedicineDao(database: HospitalDatabase): MedicineDao = database.medicineDao()

    @Provides
    @Singleton
    fun provideBedDao(database: HospitalDatabase): BedDao = database.bedDao()

    @Provides
    @Singleton
    fun provideDummyDataProvider(): DummyDataProvider = DummyDataProvider()

    @Provides
    @Singleton
    fun provideNetworkUtils(@ApplicationContext context: Context): NetworkUtils = NetworkUtils(context)
}
