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

object PengolahNamaSiswa {

    fun ambilNamaTerpanjang(daftarSiswa: List<Siswa>): String {
        return daftarSiswa
            .maxByOrNull { it.nama.length }
            ?.nama ?: "Belum ada data"
    }

    fun ambilNamaTerpendek(daftarSiswa: List<Siswa>): String {
        return daftarSiswa
            .filter { it.nama.isNotBlank() }
            .minByOrNull { it.nama.length }
            ?.nama ?: "Belum ada data"
    }
}

