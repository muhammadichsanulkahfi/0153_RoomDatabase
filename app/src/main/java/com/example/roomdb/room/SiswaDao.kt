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

object StatistikAlamatSiswa {

    fun hitungJumlahAlamatUnik(daftarSiswa: List<Siswa>): Int {
        return daftarSiswa
            .map { it.alamat.trim().lowercase() }
            .filter { it.isNotBlank() }
            .distinct()
            .size
    }

    fun hitungJumlahNamaUnik(daftarSiswa: List<Siswa>): Int {
        return daftarSiswa
            .map { it.nama.trim().lowercase() }
            .filter { it.isNotBlank() }
            .distinct()
            .size
    }
}



