package com.hospital.management.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hospital.management.presentation.screens.admin.AdminPanelScreen
import com.hospital.management.presentation.screens.admin.StaffManagementScreen
import com.hospital.management.presentation.screens.appointment.AppointmentBookingScreen
import com.hospital.management.presentation.screens.appointment.AppointmentListScreen
import com.hospital.management.presentation.screens.auth.LoginScreen
import com.hospital.management.presentation.screens.auth.OtpVerificationScreen
import com.hospital.management.presentation.screens.auth.RegisterScreen
import com.hospital.management.presentation.screens.bed.BedAvailabilityScreen
import com.hospital.management.presentation.screens.billing.BillingScreen
import com.hospital.management.presentation.screens.chat.ChatSupportScreen
import com.hospital.management.presentation.screens.dashboard.DashboardScreen
import com.hospital.management.presentation.screens.doctor.DoctorDetailScreen
import com.hospital.management.presentation.screens.doctor.DoctorListScreen
import com.hospital.management.presentation.screens.emergency.EmergencySosScreen
import com.hospital.management.presentation.screens.lab.LabTestsScreen
import com.hospital.management.presentation.screens.medicine.MedicineListScreen
import com.hospital.management.presentation.screens.notification.NotificationsScreen
import com.hospital.management.presentation.screens.onboarding.OnboardingScreen
import com.hospital.management.presentation.screens.patient.PatientListScreen
import com.hospital.management.presentation.screens.patient.AddPatientScreen
import com.hospital.management.presentation.screens.patient.PatientDetailScreen
import com.hospital.management.presentation.screens.prescription.PrescriptionDetailScreen
import com.hospital.management.presentation.screens.prescription.PrescriptionListScreen
import com.hospital.management.presentation.screens.profile.ProfileScreen
import com.hospital.management.presentation.screens.profile.EditProfileScreen
import com.hospital.management.presentation.screens.report.ReportsScreen
import com.hospital.management.presentation.screens.settings.SettingsScreen
import com.hospital.management.presentation.screens.splash.SplashScreen
import com.hospital.management.presentation.screens.staff.AttendanceScreen
import com.hospital.management.presentation.screens.tracking.AmbulanceTrackingScreen
import com.hospital.management.presentation.screens.upload.UploadDocumentsScreen
import com.hospital.management.presentation.screens.video.VideoConsultationScreen

@Composable
fun HospitalNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(
            route = Screen.OtpVerification.route,
            arguments = listOf(navArgument("phone") { type = NavType.StringType })
        ) { backStackEntry ->
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            OtpVerificationScreen(navController = navController, phone = phone)
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(Screen.PatientList.route) {
            PatientListScreen(navController = navController)
        }
        composable(
            route = Screen.PatientDetail.route,
            arguments = listOf(navArgument("patientId") { type = NavType.StringType })
        ) { backStackEntry ->
            val patientId = backStackEntry.arguments?.getString("patientId") ?: ""
            PatientDetailScreen(navController = navController, patientId = patientId)
        }
        composable(Screen.DoctorList.route) {
            DoctorListScreen(navController = navController)
        }
        composable(
            route = Screen.DoctorDetail.route,
            arguments = listOf(navArgument("doctorId") { type = NavType.StringType })
        ) { backStackEntry ->
            val doctorId = backStackEntry.arguments?.getString("doctorId") ?: ""
            DoctorDetailScreen(navController = navController, doctorId = doctorId)
        }
        composable(Screen.AppointmentBooking.route) {
            AppointmentBookingScreen(navController = navController)
        }
        composable(Screen.AppointmentList.route) {
            AppointmentListScreen(navController = navController)
        }
        composable(Screen.PrescriptionList.route) {
            PrescriptionListScreen(navController = navController)
        }
        composable(
            route = Screen.PrescriptionDetail.route,
            arguments = listOf(navArgument("prescriptionId") { type = NavType.StringType })
        ) { backStackEntry ->
            val prescriptionId = backStackEntry.arguments?.getString("prescriptionId") ?: ""
            PrescriptionDetailScreen(navController = navController, prescriptionId = prescriptionId)
        }
        composable(Screen.MedicineList.route) {
            MedicineListScreen(navController = navController)
        }
        composable(Screen.Billing.route) {
            BillingScreen(navController = navController)
        }
        composable(Screen.LabTests.route) {
            LabTestsScreen(navController = navController)
        }
        composable(Screen.EmergencySos.route) {
            EmergencySosScreen(navController = navController)
        }
        composable(Screen.AmbulanceTracking.route) {
            AmbulanceTrackingScreen(navController = navController)
        }
        composable(Screen.BedAvailability.route) {
            BedAvailabilityScreen(navController = navController)
        }
        composable(Screen.Reports.route) {
            ReportsScreen(navController = navController)
        }
        composable(Screen.Notifications.route) {
            NotificationsScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(Screen.EditProfile.route) {
            EditProfileScreen(navController = navController)
        }
        composable(Screen.AddPatient.route) {
            AddPatientScreen(navController = navController)
        }
        composable(Screen.ChatSupport.route) {
            ChatSupportScreen(navController = navController)
        }
        composable(Screen.VideoConsultation.route) {
            VideoConsultationScreen(navController = navController)
        }
        composable(Screen.UploadDocuments.route) {
            UploadDocumentsScreen(navController = navController)
        }
        composable(Screen.AdminPanel.route) {
            AdminPanelScreen(navController = navController)
        }
        composable(Screen.StaffManagement.route) {
            StaffManagementScreen(navController = navController)
        }
        composable(Screen.Attendance.route) {
            AttendanceScreen(navController = navController)
        }
    }
}
