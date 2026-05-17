package com.hospital.management.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hospital.management.data.model.Appointment
import com.hospital.management.data.model.Bed
import com.hospital.management.data.model.Doctor
import com.hospital.management.data.model.Medicine
import com.hospital.management.data.model.Patient
import com.hospital.management.data.model.Prescription

@Database(
    entities = [
        Patient::class,
        Doctor::class,
        Appointment::class,
        Prescription::class,
        Medicine::class,
        Bed::class
    ],
    version = 1,
    exportSchema = false
)
abstract class HospitalDatabase : RoomDatabase() {
    abstract fun patientDao(): PatientDao
    abstract fun doctorDao(): DoctorDao
    abstract fun appointmentDao(): AppointmentDao
    abstract fun prescriptionDao(): PrescriptionDao
    abstract fun medicineDao(): MedicineDao
    abstract fun bedDao(): BedDao
}
