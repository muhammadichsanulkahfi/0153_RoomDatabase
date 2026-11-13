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

object PemeriksaAlamat {

    fun cariBerdasarkanKota(
        daftarSiswa: List<Siswa>,
        kataKunci: String
    ): List<Siswa> {
        if (kataKunci.isBlank()) return emptyList()

        return daftarSiswa.filter {
            it.alamat.contains(kataKunci.trim(), ignoreCase = true)
        }
    }

    fun cekAlamatSama(
        daftarSiswa: List<Siswa>,
        alamat: String
    ): Boolean {
        return daftarSiswa.any {
            it.alamat.equals(alamat.trim(), ignoreCase = true)
        }
    }
}



