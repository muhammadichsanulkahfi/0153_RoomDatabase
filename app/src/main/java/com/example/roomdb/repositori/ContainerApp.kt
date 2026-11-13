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

object PencarianSiswa {

    fun cariSiswa(
        daftarSiswa: List<Siswa>,
        kataKunci: String
    ): List<Siswa> {
        return daftarSiswa.filter { siswa ->
            siswa.nama.contains(
                kataKunci,
                ignoreCase = true
            )
        }
    }
}