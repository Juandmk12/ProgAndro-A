package com.example.pertemuan7_71190513

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listKontak = ArrayList<Kontak>()
        listKontak.add(Kontak("Juan Matthew Damanik", "085358376441", R.mipmap.bgcover, 1))
        listKontak.add(Kontak("Edgar Timoti Damanik", "085261667211", R.mipmap.bg2cover, 2))
        listKontak.add(Kontak("Boy Philip Damanik", "081635874550", R.mipmap.bg3cover, 3))

        val rcyKontak = findViewById<RecyclerView>(R.id.rcyKontak)
        rcyKontak.layoutManager = LinearLayoutManager(this)
        val kontakAdaptor = KontakAdaptor(listKontak)
        rcyKontak.adapter = kontakAdaptor
    }
}