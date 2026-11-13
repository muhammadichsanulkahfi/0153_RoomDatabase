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

object CadanganSiswa {

    fun buatCadangan(daftarSiswa: List<Siswa>): String {
        return daftarSiswa.joinToString(separator = "\n") { siswa ->
            "${siswa.id}|${siswa.nama}|${siswa.alamat}|${siswa.telpon}"
        }
    }

    fun jumlahDataCadangan(data: String): Int {
        return data.lines().count { it.isNotBlank() }
    }
}
