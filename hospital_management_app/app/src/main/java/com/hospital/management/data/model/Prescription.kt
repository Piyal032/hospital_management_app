package com.hospital.management.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "prescriptions")
data class Prescription(
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
    @SerializedName("diagnosis")
    val diagnosis: String,
    @SerializedName("medicines")
    val medicines: String,
    @SerializedName("instructions")
    val instructions: String? = null,
    @ColumnInfo(name = "follow_up_date")
    @SerializedName("follow_up_date")
    val followUpDate: String? = null,
    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    val createdAt: String = ""
)

@Entity(tableName = "medicines")
data class Medicine(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "generic_name")
    @SerializedName("generic_name")
    val genericName: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("dosage")
    val dosage: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @ColumnInfo(name = "expiry_date")
    @SerializedName("expiry_date")
    val expiryDate: String,
    @SerializedName("description")
    val description: String? = null
)
