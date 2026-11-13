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

object StatistikSiswa {

    fun hitungJumlahSiswa(
        daftarSiswa: List<Siswa>
    ): Int {
        return daftarSiswa.size
    }

    fun cekApakahKosong(
        daftarSiswa: List<Siswa>
    ): Boolean {
        return daftarSiswa.isEmpty()
    }

    fun cekApakahAdaData(
        daftarSiswa: List<Siswa>
    ): Boolean {
        return daftarSiswa.isNotEmpty()
    }
}