package com.hospital.management.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hospital.management.data.model.Doctor
import kotlinx.coroutines.flow.Flow

@Dao
interface DoctorDao {
    @Query("SELECT * FROM doctors ORDER BY name ASC")
    fun getAllDoctors(): Flow<List<Doctor>>

    @Query("SELECT * FROM doctors WHERE id = :doctorId")
    suspend fun getDoctorById(doctorId: String): Doctor?

    @Query("SELECT * FROM doctors WHERE specialization = :specialization")
    fun getDoctorsBySpecialization(specialization: String): Flow<List<Doctor>>

    @Query("SELECT * FROM doctors WHERE name LIKE '%' || :query || '%' OR specialization LIKE '%' || :query || '%'")
    fun searchDoctors(query: String): Flow<List<Doctor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoctors(doctors: List<Doctor>)

    @Query("DELETE FROM doctors")
    suspend fun deleteAllDoctors()
}
