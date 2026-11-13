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

object PemeriksaSiswa {

    fun apakahNamaSudahAda(
        daftarSiswa: List<Siswa>,
        nama: String
    ): Boolean {
        return daftarSiswa.any {
            it.nama.equals(nama.trim(), ignoreCase = true)
        }
    }

    fun apakahNomorTeleponSudahAda(
        daftarSiswa: List<Siswa>,
        telpon: String
    ): Boolean {
        return daftarSiswa.any {
            it.telpon == telpon
        }
    }

    fun apakahDataKosong(
        daftarSiswa: List<Siswa>
    ): Boolean {
        return daftarSiswa.isEmpty()
    }
}
