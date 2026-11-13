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

object UrutanSiswa {

    fun urutkanAlamat(daftarSiswa: List<Siswa>): List<Siswa> {
        return daftarSiswa.sortedBy { it.alamat.lowercase() }
    }

    fun urutkanTelepon(daftarSiswa: List<Siswa>): List<Siswa> {
        return daftarSiswa.sortedBy { it.telpon }
    }

    fun urutkanTerbaru(daftarSiswa: List<Siswa>): List<Siswa> {
        return daftarSiswa.sortedByDescending { it.id }
    }
}



