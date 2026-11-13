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

object FilterSiswa {

    fun filterNama(
        daftarSiswa: List<Siswa>,
        kataKunci: String
    ): List<Siswa> {
        if (kataKunci.isBlank()) {
            return daftarSiswa
        }

        return daftarSiswa.filter {
            it.nama.contains(kataKunci, ignoreCase = true)
        }
    }

    fun filterAlamat(
        daftarSiswa: List<Siswa>,
        alamat: String
    ): List<Siswa> {
        if (alamat.isBlank()) {
            return daftarSiswa
        }

        return daftarSiswa.filter {
            it.alamat.contains(alamat, ignoreCase = true)
        }
    }
}
