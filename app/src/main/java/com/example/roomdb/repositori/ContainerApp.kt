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

object FormatDataSiswa {

    fun formatNama(nama: String): String {
        return nama.trim()
            .split(" ")
            .filter { it.isNotBlank() }
            .joinToString(" ") {
                it.lowercase().replaceFirstChar { huruf ->
                    huruf.uppercase()
                }
            }
    }

    fun formatAlamat(alamat: String): String {
        return alamat.trim()
    }

    fun formatNomorTelepon(nomor: String): String {
        return nomor.filter { it.isDigit() }
    }
}