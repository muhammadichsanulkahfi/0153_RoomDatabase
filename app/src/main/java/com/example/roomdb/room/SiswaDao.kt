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

object EksporSiswa {

    fun buatCSV(daftarSiswa: List<Siswa>): String {
        val header = "ID,Nama,Alamat,Telepon"

        val isi = daftarSiswa.map { siswa ->
            listOf(
                siswa.id.toString(),
                siswa.nama,
                siswa.alamat,
                siswa.telpon
            ).joinToString(",") { nilai ->
                "\"${nilai.replace("\"", "\"\"")}\""
            }
        }

        return (listOf(header) + isi).joinToString("\n")
    }
}
