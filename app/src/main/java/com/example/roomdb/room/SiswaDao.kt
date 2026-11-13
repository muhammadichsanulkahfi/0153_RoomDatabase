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

object PengelompokanSiswa {

    fun kelompokkanBerdasarkanHuruf(
        daftarSiswa: List<Siswa>
    ): Map<Char, List<Siswa>> {
        return daftarSiswa
            .filter { it.nama.isNotBlank() }
            .groupBy { it.nama.trim().first().uppercaseChar() }
            .toSortedMap()
    }

    fun kelompokkanBerdasarkanAlamat(
        daftarSiswa: List<Siswa>
    ): Map<String, List<Siswa>> {
        return daftarSiswa.groupBy { it.alamat.trim() }
    }
}


