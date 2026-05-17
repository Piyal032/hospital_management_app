package com.hospital.management.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hospital.management.data.model.Bed
import kotlinx.coroutines.flow.Flow

@Dao
interface BedDao {
    @Query("SELECT * FROM beds ORDER BY ward_number, bed_number")
    fun getAllBeds(): Flow<List<Bed>>

    @Query("SELECT * FROM beds WHERE status = 'available'")
    fun getAvailableBeds(): Flow<List<Bed>>

    @Query("SELECT * FROM beds WHERE ward_number = :wardNumber")
    fun getBedsByWard(wardNumber: String): Flow<List<Bed>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBeds(beds: List<Bed>)

    @Query("DELETE FROM beds")
    suspend fun deleteAllBeds()
}
