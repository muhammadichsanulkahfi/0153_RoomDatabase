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

object RingkasanSiswa {

    fun jumlahSiswa(
        daftarSiswa: List<Siswa>
    ): Int {
        return daftarSiswa.size
    }

    fun jumlahSiswaDenganNama(
        daftarSiswa: List<Siswa>,
        kataKunci: String
    ): Int {
        return daftarSiswa.count {
            it.nama.contains(kataKunci, ignoreCase = true)
        }
    }

    fun daftarNamaSiswa(
        daftarSiswa: List<Siswa>
    ): List<String> {
        return daftarSiswa.map { it.nama }
    }
}
