package com.hospital.management.data.remote

import com.hospital.management.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // Auth
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<LoginResponse>

    @POST("auth/verify-otp")
    suspend fun verifyOtp(@Body request: Map<String, String>): Response<LoginResponse>

    @POST("auth/resend-otp")
    suspend fun resendOtp(@Body request: Map<String, String>): Response<BaseResponse>

    // Patients
    @GET("patients")
    suspend fun getPatients(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<PatientResponse>

    @GET("patients/{id}")
    suspend fun getPatientById(@Path("id") id: String): Response<PatientResponse>

    @POST("patients")
    suspend fun createPatient(@Body patient: Patient): Response<BaseResponse>

    // Doctors
    @GET("doctors")
    suspend fun getDoctors(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<DoctorResponse>

    @GET("doctors/{id}")
    suspend fun getDoctorById(@Path("id") id: String): Response<DoctorResponse>

    // Appointments
    @GET("appointments")
    suspend fun getAppointments(): Response<AppointmentResponse>

    @POST("appointments")
    suspend fun bookAppointment(@Body appointment: Appointment): Response<BaseResponse>

    @PUT("appointments/{id}/status")
    suspend fun updateAppointmentStatus(
        @Path("id") id: String,
        @Body status: Map<String, String>
    ): Response<BaseResponse>

    // Prescriptions
    @GET("prescriptions")
    suspend fun getPrescriptions(): Response<PrescriptionResponse>

    @POST("prescriptions")
    suspend fun createPrescription(@Body prescription: Prescription): Response<BaseResponse>

    // Medicines
    @GET("medicines")
    suspend fun getMedicines(): Response<MedicineResponse>

    // Beds
    @GET("beds")
    suspend fun getBeds(): Response<BedResponse>

    // Billing
    @GET("billing")
    suspend fun getBilling(): Response<BillingResponse>

    // Lab Tests
    @GET("lab-tests")
    suspend fun getLabTests(): Response<LabTestResponse>

    // Reports
    @GET("reports/dashboard")
    suspend fun getDashboardStats(): Response<DashboardStatsResponse>
}

data class BaseResponse(
    val success: Boolean,
    val message: String?
)

data class PrescriptionResponse(
    val success: Boolean,
    val message: String?,
    val data: List<Prescription>?
)

data class MedicineResponse(
    val success: Boolean,
    val message: String?,
    val data: List<Medicine>?
)

data class BillingResponse(
    val success: Boolean,
    val message: String?,
    val data: List<BillingItem>?
)

data class LabTestResponse(
    val success: Boolean,
    val message: String?,
    val data: List<LabTest>?
)

data class DashboardStatsResponse(
    val success: Boolean,
    val data: DashboardStats?
)

data class BillingItem(
    val id: String,
    val patientName: String,
    val description: String,
    val amount: Double,
    val status: String,
    val date: String
)

data class LabTest(
    val id: String,
    val patientName: String,
    val testName: String,
    val doctorName: String,
    val status: String,
    val result: String?,
    val date: String
)

data class DashboardStats(
    val totalPatients: Int,
    val totalDoctors: Int,
    val totalAppointments: Int,
    val todayAppointments: Int,
    val availableBeds: Int,
    val occupiedBeds: Int,
    val totalRevenue: Double,
    val pendingBills: Int
)
