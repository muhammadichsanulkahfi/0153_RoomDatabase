package com.example.roomdb.repositori

import android.content.Context
import com.example.roomdb.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}



package com.example.roomdb.repositori

import com.example.roomdb.room.Siswa

object UrutkanSiswa {

    fun urutkanNamaAtoZ(
        daftarSiswa: List<Siswa>
    ): List<Siswa> {
        return daftarSiswa.sortedBy {
            it.nama.lowercase()
        }
    }

    fun urutkanNamaZtoA(
        daftarSiswa: List<Siswa>
    ): List<Siswa> {
        return daftarSiswa.sortedByDescending {
            it.nama.lowercase()
        }
    }
}