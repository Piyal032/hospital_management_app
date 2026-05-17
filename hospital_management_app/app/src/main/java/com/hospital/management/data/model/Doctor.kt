package com.hospital.management.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "doctors")
data class Doctor(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("specialization")
    val specialization: String,
    @SerializedName("qualification")
    val qualification: String,
    @SerializedName("experience_years")
    val experienceYears: Int,
    @SerializedName("department")
    val department: String,
    @SerializedName("consultation_fee")
    val consultationFee: Double,
    @SerializedName("available_days")
    val availableDays: String,
    @SerializedName("available_time")
    val availableTime: String,
    @SerializedName("profile_image")
    val profileImage: String? = null,
    @SerializedName("rating")
    val rating: Float = 0f,
    @SerializedName("total_reviews")
    val totalReviews: Int = 0,
    @SerializedName("is_available")
    val isAvailable: Boolean = true,
    @SerializedName("about")
    val about: String? = null,
    @SerializedName("status")
    val status: String = "active"
)

data class DoctorResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: List<Doctor>?
)
