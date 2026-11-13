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

object ValidasiSiswa {

    fun cekNama(nama: String): Boolean {
        return nama.isNotBlank()
    }

    fun cekAlamat(alamat: String): Boolean {
        return alamat.isNotBlank()
    }

    fun cekNomorTelepon(nomor: String): Boolean {
        return nomor.isNotBlank() &&
                nomor.all { it.isDigit() } &&
                nomor.length >= 10
    }

    fun cekDataSiswa(
        nama: String,
        alamat: String,
        nomor: String
    ): Boolean {
        return cekNama(nama) &&
                cekAlamat(alamat) &&
                cekNomorTelepon(nomor)
    }
}