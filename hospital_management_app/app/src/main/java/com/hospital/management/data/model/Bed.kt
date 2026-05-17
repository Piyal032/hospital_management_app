package com.hospital.management.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "beds")
data class Bed(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "ward_number")
    @SerializedName("ward_number")
    val wardNumber: String,
    @ColumnInfo(name = "bed_number")
    @SerializedName("bed_number")
    val bedNumber: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("status")
    val status: String,
    @ColumnInfo(name = "patient_id")
    @SerializedName("patient_id")
    val patientId: String? = null,
    @ColumnInfo(name = "patient_name")
    @SerializedName("patient_name")
    val patientName: String? = null,
    @ColumnInfo(name = "daily_charge")
    @SerializedName("daily_charge")
    val dailyCharge: Double,
    @SerializedName("floor")
    val floor: Int,
    @SerializedName("department")
    val department: String
)

data class BedResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data: List<Bed>?,
    @SerializedName("total_available")
    val totalAvailable: Int = 0,
    @SerializedName("total_occupied")
    val totalOccupied: Int = 0
)
