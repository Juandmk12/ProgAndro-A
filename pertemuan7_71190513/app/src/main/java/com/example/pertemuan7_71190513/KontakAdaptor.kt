package com.example.pertemuan7_71190513

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class KontakAdaptor (val listKontak: ArrayList<Kontak>): RecyclerView.Adapter<KontakAdaptor.KontakHolder>(){
    class KontakHolder(val v: View): RecyclerView.ViewHolder(v){
        var kontak: Kontak? = null

        fun bindView(kontak: Kontak){
            this.kontak = kontak

            v.findViewById<TextView>(R.id.txvNama).text = "#${kontak.rank} ${kontak.nama}"
            v.findViewById<TextView>(R.id.txvNomor).text = kontak.nomor
            v.findViewById<ImageView>(R.id.imgCover).setImageResource(kontak.cover)
            v.setOnClickListener{
                Toast.makeText(v.context, "${kontak.nomor} - ${kontak.nama}", Toast.LENGTH_LONG).show()
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_kontak, parent, false)
        return  KontakHolder(v)
    }

    override fun onBindViewHolder(holder: KontakHolder, position: Int) {
        holder.bindView(listKontak[position])
    }

    override fun getItemCount(): Int = listKontak.size
}