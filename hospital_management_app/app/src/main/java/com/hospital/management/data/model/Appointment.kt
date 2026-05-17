package com.hospital.management.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "appointments")
data class Appointment(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "patient_id")
    @SerializedName("patient_id")
    val patientId: String,
    @ColumnInfo(name = "patient_name")
    @SerializedName("patient_name")
    val patientName: String,
    @ColumnInfo(name = "doctor_id")
    @SerializedName("doctor_id")
    val doctorId: String,
    @ColumnInfo(name = "doctor_name")
    @SerializedName("doctor_name")
    val doctorName: String,
    @SerializedName("department")
    val department: String,
    @ColumnInfo(name = "appointment_date")
    @SerializedName("appointment_date")
    val appointmentDate: String,
    @ColumnInfo(name = "appointment_time")
    @SerializedName("appointment_time")
    val appointmentTime: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String = "in_person",
    @SerializedName("symptoms")
    val symptoms: String? = null,
    @SerializedName("notes")
    val notes: String? = null,
    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    val createdAt: String = ""
)

data class AppointmentResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: List<Appointment>?
)
