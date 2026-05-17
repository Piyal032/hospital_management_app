package com.hospital.management.presentation.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Onboarding : Screen("onboarding")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object OtpVerification : Screen("otp_verification/{phone}") {
        fun createRoute(phone: String) = "otp_verification/$phone"
    }
    data object Dashboard : Screen("dashboard")
    data object PatientList : Screen("patient_list")
    data object PatientDetail : Screen("patient_detail/{patientId}") {
        fun createRoute(patientId: String) = "patient_detail/$patientId"
    }
    data object DoctorList : Screen("doctor_list")
    data object DoctorDetail : Screen("doctor_detail/{doctorId}") {
        fun createRoute(doctorId: String) = "doctor_detail/$doctorId"
    }
    data object AppointmentBooking : Screen("appointment_booking")
    data object AppointmentList : Screen("appointment_list")
    data object PrescriptionList : Screen("prescription_list")
    data object PrescriptionDetail : Screen("prescription_detail/{prescriptionId}") {
        fun createRoute(prescriptionId: String) = "prescription_detail/$prescriptionId"
    }
    data object MedicineList : Screen("medicine_list")
    data object Billing : Screen("billing")
    data object LabTests : Screen("lab_tests")
    data object EmergencySos : Screen("emergency_sos")
    data object AmbulanceTracking : Screen("ambulance_tracking")
    data object BedAvailability : Screen("bed_availability")
    data object Reports : Screen("reports")
    data object Notifications : Screen("notifications")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object ChatSupport : Screen("chat_support")
    data object VideoConsultation : Screen("video_consultation")
    data object MedicalHistory : Screen("medical_history")
    data object UploadDocuments : Screen("upload_documents")
    data object AdminPanel : Screen("admin_panel")
    data object StaffManagement : Screen("staff_management")
    data object Attendance : Screen("attendance")
    data object EditProfile : Screen("edit_profile")
    data object AddPatient : Screen("add_patient")
}
