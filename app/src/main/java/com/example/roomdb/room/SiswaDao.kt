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

import com.example.roomdb.room.Siswa

object RingkasanTelepon {

    fun daftarTelepon(daftarSiswa: List<Siswa>): List<String> {
        return daftarSiswa
            .map { it.telpon }
            .filter { it.isNotBlank() }
            .distinct()
    }

    fun jumlahTelepon(daftarSiswa: List<Siswa>): Int {
        return daftarTelepon(daftarSiswa).size
    }
}

