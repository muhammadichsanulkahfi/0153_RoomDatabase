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

object PenghitungSiswa {

    fun hitungNamaTerisi(daftarSiswa: List<Siswa>): Int {
        return daftarSiswa.count { it.nama.isNotBlank() }
    }

    fun hitungAlamatTerisi(daftarSiswa: List<Siswa>): Int {
        return daftarSiswa.count { it.alamat.isNotBlank() }
    }

    fun hitungTeleponTerisi(daftarSiswa: List<Siswa>): Int {
        return daftarSiswa.count { it.telpon.isNotBlank() }
    }
}


