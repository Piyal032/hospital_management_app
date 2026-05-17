package com.hospital.management.util

import com.hospital.management.data.model.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyDataProvider @Inject constructor() {

    fun getDummyPatients(): List<Patient> = listOf(
        Patient(
            id = "P001", name = "Rahul Sharma", email = "rahul@email.com",
            phone = "+91 98765 43210", age = 35, gender = "Male",
            bloodGroup = "O+", address = "Sector 18, Noida, UP",
            emergencyContact = "+91 98765 43211",
            medicalHistory = "Diabetes Type 2, Hypertension",
            allergies = "Penicillin", admissionDate = "2026-05-10",
            wardNumber = "W-101", bedNumber = "B-12", status = "active"
        ),
        Patient(
            id = "P002", name = "Priya Patel", email = "priya@email.com",
            phone = "+91 98765 43212", age = 28, gender = "Female",
            bloodGroup = "A+", address = "Raj Nagar, Ghaziabad, UP",
            emergencyContact = "+91 98765 43213",
            medicalHistory = "Asthma", admissionDate = "2026-05-12",
            wardNumber = "W-102", bedNumber = "B-05", status = "active"
        ),
        Patient(
            id = "P003", name = "Amit Kumar", email = "amit@email.com",
            phone = "+91 98765 43214", age = 45, gender = "Male",
            bloodGroup = "B+", address = "Green Park, Delhi",
            emergencyContact = "+91 98765 43215",
            medicalHistory = "Heart Disease",
            allergies = "Sulfa drugs", admissionDate = "2026-05-14",
            wardNumber = "ICU-01", bedNumber = "ICU-03", status = "critical"
        ),
        Patient(
            id = "P004", name = "Sneha Gupta", email = "sneha@email.com",
            phone = "+91 98765 43216", age = 32, gender = "Female",
            bloodGroup = "AB+", address = "Vasant Kunj, Delhi",
            emergencyContact = "+91 98765 43217",
            admissionDate = "2026-05-15",
            wardNumber = "W-103", bedNumber = "B-08", status = "active"
        ),
        Patient(
            id = "P005", name = "Vikram Singh", email = "vikram@email.com",
            phone = "+91 98765 43218", age = 55, gender = "Male",
            bloodGroup = "O-", address = "Model Town, Delhi",
            emergencyContact = "+91 98765 43219",
            medicalHistory = "Arthritis, High BP",
            allergies = "Aspirin", admissionDate = "2026-05-11",
            wardNumber = "W-101", bedNumber = "B-15", status = "active"
        )
    )

    fun getDummyDoctors(): List<Doctor> = listOf(
        Doctor(
            id = "D001", name = "Dr. Rajesh Verma", email = "dr.rajesh@hospital.com",
            phone = "+91 98765 43220", specialization = "Cardiology",
            qualification = "MBBS, MD, DM (Cardiology)", experienceYears = 15,
            department = "Cardiology", consultationFee = 800.0,
            availableDays = "Mon, Wed, Fri", availableTime = "10:00 AM - 2:00 PM",
            rating = 4.8f, totalReviews = 234, isAvailable = true,
            about = "Senior cardiologist with 15+ years experience"
        ),
        Doctor(
            id = "D002", name = "Dr. Priya Nair", email = "dr.priya@hospital.com",
            phone = "+91 98765 43221", specialization = "Neurology",
            qualification = "MBBS, MD, DM (Neurology)", experienceYears = 12,
            department = "Neurology", consultationFee = 1000.0,
            availableDays = "Tue, Thu, Sat", availableTime = "11:00 AM - 3:00 PM",
            rating = 4.9f, totalReviews = 189, isAvailable = true,
            about = "Expert in stroke management"
        ),
        Doctor(
            id = "D003", name = "Dr. Amit Khanna", email = "dr.amit@hospital.com",
            phone = "+91 98765 43222", specialization = "Orthopedics",
            qualification = "MBBS, MS (Ortho)", experienceYears = 10,
            department = "Orthopedics", consultationFee = 700.0,
            availableDays = "Mon-Fri", availableTime = "9:00 AM - 1:00 PM",
            rating = 4.6f, totalReviews = 156, isAvailable = true,
            about = "Joint replacement specialist"
        ),
        Doctor(
            id = "D004", name = "Dr. Sunita Reddy", email = "dr.sunita@hospital.com",
            phone = "+91 98765 43223", specialization = "Gynecology",
            qualification = "MBBS, MD (Gynecology)", experienceYears = 14,
            department = "Gynecology", consultationFee = 600.0,
            availableDays = "Mon, Wed, Fri, Sat", availableTime = "10:00 AM - 4:00 PM",
            rating = 4.7f, totalReviews = 312, isAvailable = true,
            about = "High-risk pregnancy expert"
        ),
        Doctor(
            id = "D005", name = "Dr. Vikram Joshi", email = "dr.vikram@hospital.com",
            phone = "+91 98765 43224", specialization = "Pediatrics",
            qualification = "MBBS, MD (Pediatrics)", experienceYears = 8,
            department = "Pediatrics", consultationFee = 500.0,
            availableDays = "Tue-Sat", availableTime = "9:30 AM - 1:30 PM",
            rating = 4.9f, totalReviews = 278, isAvailable = true,
            about = "Child specialist, neonatal care"
        ),
        Doctor(
            id = "D006", name = "Dr. Ananya Mishra", email = "dr.ananya@hospital.com",
            phone = "+91 98765 43225", specialization = "Dermatology",
            qualification = "MBBS, MD (Dermatology)", experienceYears = 11,
            department = "Dermatology", consultationFee = 750.0,
            availableDays = "Mon, Tue, Thu, Fri", availableTime = "2:00 PM - 6:00 PM",
            rating = 4.5f, totalReviews = 145, isAvailable = false,
            about = "Cosmetic dermatology expert"
        )
    )

    fun getDummyAppointments(): List<Appointment> = listOf(
        Appointment(
            id = "A001", patientId = "P001", patientName = "Rahul Sharma",
            doctorId = "D001", doctorName = "Dr. Rajesh Verma",
            department = "Cardiology", appointmentDate = "2026-05-16",
            appointmentTime = "10:30 AM", status = "confirmed",
            type = "in_person", symptoms = "Chest pain, shortness of breath",
            notes = "Follow-up for hypertension"
        ),
        Appointment(
            id = "A002", patientId = "P002", patientName = "Priya Patel",
            doctorId = "D004", doctorName = "Dr. Sunita Reddy",
            department = "Gynecology", appointmentDate = "2026-05-16",
            appointmentTime = "11:00 AM", status = "pending",
            type = "in_person", symptoms = "Regular checkup",
            notes = "3rd trimester pregnancy checkup"
        ),
        Appointment(
            id = "A003", patientId = "P003", patientName = "Amit Kumar",
            doctorId = "D001", doctorName = "Dr. Rajesh Verma",
            department = "Cardiology", appointmentDate = "2026-05-15",
            appointmentTime = "2:00 PM", status = "completed",
            type = "in_person", symptoms = "Severe chest pain",
            notes = "ECG done, prescribed medication"
        ),
        Appointment(
            id = "A004", patientId = "P004", patientName = "Sneha Gupta",
            doctorId = "D002", doctorName = "Dr. Priya Nair",
            department = "Neurology", appointmentDate = "2026-05-17",
            appointmentTime = "11:30 AM", status = "confirmed",
            type = "video", symptoms = "Frequent headaches",
            notes = "Video consultation for migraine"
        ),
        Appointment(
            id = "A005", patientId = "P005", patientName = "Vikram Singh",
            doctorId = "D003", doctorName = "Dr. Amit Khanna",
            department = "Orthopedics", appointmentDate = "2026-05-17",
            appointmentTime = "10:00 AM", status = "confirmed",
            type = "in_person", symptoms = "Knee joint pain",
            notes = "X-ray required"
        )
    )

    fun getDummyPrescriptions(): List<Prescription> = listOf(
        Prescription(
            id = "PR001", patientId = "P001", patientName = "Rahul Sharma",
            doctorId = "D001", doctorName = "Dr. Rajesh Verma",
            diagnosis = "Hypertension Stage 1",
            medicines = """1. Amlodipine 5mg - 1 tab daily morning
2. Metformin 500mg - 1 tab after lunch
3. Atorvastatin 10mg - 1 tab at night""",
            instructions = "Take medicines after food. Monitor BP daily. Avoid salt.",
            followUpDate = "2026-06-15", createdAt = "2026-05-15"
        ),
        Prescription(
            id = "PR002", patientId = "P002", patientName = "Priya Patel",
            doctorId = "D004", doctorName = "Dr. Sunita Reddy",
            diagnosis = "Normal Pregnancy - 3rd Trimester",
            medicines = """1. Iron Folic Acid - 1 tab daily
2. Calcium tablets - 1 tab twice daily
3. Vitamin D3 - 1 tab weekly""",
            instructions = "Regular walks. Balanced diet. Sleep on left side.",
            followUpDate = "2026-05-29", createdAt = "2026-05-15"
        ),
        Prescription(
            id = "PR003", patientId = "P003", patientName = "Amit Kumar",
            doctorId = "D001", doctorName = "Dr. Rajesh Verma",
            diagnosis = "Acute Coronary Syndrome",
            medicines = """1. Aspirin 75mg - 1 tab daily
2. Clopidogrel 75mg - 1 tab daily
3. Atorvastatin 40mg - 1 tab at night
4. Metoprolol 50mg - 1 tab twice daily""",
            instructions = "Complete bed rest. Low fat diet. Regular monitoring.",
            followUpDate = "2026-05-18", createdAt = "2026-05-15"
        )
    )

    fun getDummyMedicines(): List<Medicine> = listOf(
        Medicine(
            id = "M001", name = "Paracetamol 500mg", genericName = "Acetaminophen",
            category = "Pain Relief", dosage = "1-2 tablets every 4-6 hours",
            price = 25.50, stock = 500, manufacturer = "Cipla Ltd",
            expiryDate = "2027-12-31",
            description = "Used for fever and mild to moderate pain"
        ),
        Medicine(
            id = "M002", name = "Amoxicillin 500mg", genericName = "Amoxicillin",
            category = "Antibiotics", dosage = "1 capsule three times daily",
            price = 85.00, stock = 300, manufacturer = "Sun Pharma",
            expiryDate = "2027-10-15",
            description = "Broad-spectrum antibiotic"
        ),
        Medicine(
            id = "M003", name = "Amlodipine 5mg", genericName = "Amlodipine Besylate",
            category = "Cardiovascular", dosage = "1 tablet daily morning",
            price = 45.00, stock = 200, manufacturer = "Dr. Reddy's",
            expiryDate = "2028-03-20",
            description = "Calcium channel blocker for hypertension"
        ),
        Medicine(
            id = "M004", name = "Metformin 500mg", genericName = "Metformin HCl",
            category = "Diabetes", dosage = "1 tablet twice daily after meals",
            price = 35.00, stock = 400, manufacturer = "Lupin Ltd",
            expiryDate = "2027-08-30",
            description = "First-line medication for Type 2 diabetes"
        ),
        Medicine(
            id = "M005", name = "Omeprazole 20mg", genericName = "Omeprazole",
            category = "Gastrointestinal", dosage = "1 capsule before breakfast",
            price = 55.00, stock = 250, manufacturer = "Zydus Cadila",
            expiryDate = "2027-11-15",
            description = "Proton pump inhibitor for acid reflux"
        )
    )

    fun getDummyBeds(): List<Bed> = listOf(
        Bed("B001", "W-101", "B-01", "General", "available", null, null, 1500.0, 1, "General Medicine"),
        Bed("B002", "W-101", "B-02", "General", "occupied", "P001", "Rahul Sharma", 1500.0, 1, "General Medicine"),
        Bed("B003", "W-101", "B-03", "General", "available", null, null, 1500.0, 1, "General Medicine"),
        Bed("B004", "W-102", "B-04", "Semi-Private", "occupied", "P002", "Priya Patel", 2500.0, 1, "Gynecology"),
        Bed("B005", "W-102", "B-05", "Semi-Private", "available", null, null, 2500.0, 1, "Gynecology"),
        Bed("B006", "ICU-01", "ICU-01", "ICU", "available", null, null, 8000.0, 2, "Critical Care"),
        Bed("B007", "ICU-01", "ICU-02", "ICU", "available", null, null, 8000.0, 2, "Critical Care"),
        Bed("B008", "ICU-01", "ICU-03", "ICU", "occupied", "P003", "Amit Kumar", 8000.0, 2, "Critical Care"),
        Bed("B009", "W-201", "B-06", "Private", "available", null, null, 5000.0, 2, "Cardiology"),
        Bed("B010", "W-201", "B-07", "Private", "maintenance", null, null, 5000.0, 2, "Cardiology")
    )

    fun getDummyDashboardStats(): DashboardStats = DashboardStats(
        totalPatients = 1250, totalDoctors = 45, totalAppointments = 89,
        todayAppointments = 24, availableBeds = 45, occupiedBeds = 38,
        totalRevenue = 285000.0, pendingBills = 12
    )
}

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
