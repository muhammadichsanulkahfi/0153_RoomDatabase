package com.example.roomdb.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SiswaDao {
    @Query("SELECT * FROM tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)
}








package com.example.roomdb.repositori

object ImporSiswa {

    fun bacaCSV(dataCSV: String): List<List<String>> {
        return dataCSV
            .lines()
            .drop(1)
            .filter { it.isNotBlank() }
            .map { baris ->
                baris.split(",").map { nilai ->
                    nilai.trim().removeSurrounding("\"")
                }
            }
    }
}
