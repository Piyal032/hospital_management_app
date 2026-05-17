package com.hospital.management.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("blood_group")
    val bloodGroup: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("emergency_contact")
    val emergencyContact: String,
    @SerializedName("medical_history")
    val medicalHistory: String? = null,
    @SerializedName("allergies")
    val allergies: String? = null,
    @SerializedName("profile_image")
    val profileImage: String? = null,
    @SerializedName("admission_date")
    val admissionDate: String? = null,
    @SerializedName("ward_number")
    val wardNumber: String? = null,
    @SerializedName("bed_number")
    val bedNumber: String? = null,
    @SerializedName("status")
    val status: String = "active",
    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("updated_at")
    val updatedAt: String = ""
)

data class PatientResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: List<Patient>?,
    @SerializedName("total")
    val total: Int? = 0
)
