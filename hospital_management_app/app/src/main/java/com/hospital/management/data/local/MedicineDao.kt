package com.hospital.management.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hospital.management.data.model.Medicine
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicines ORDER BY name ASC")
    fun getAllMedicines(): Flow<List<Medicine>>

    @Query("SELECT * FROM medicines WHERE category = :category")
    fun getMedicinesByCategory(category: String): Flow<List<Medicine>>

    @Query("SELECT * FROM medicines WHERE name LIKE '%' || :query || '%'")
    fun searchMedicines(query: String): Flow<List<Medicine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicines(medicines: List<Medicine>)

    @Query("DELETE FROM medicines")
    suspend fun deleteAllMedicines()
}
