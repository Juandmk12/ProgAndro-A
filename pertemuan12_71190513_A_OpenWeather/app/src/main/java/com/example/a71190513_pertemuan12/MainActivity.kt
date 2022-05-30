package com.example.a71190513_pertemuan12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtKota = findViewById<EditText>(R.id.edtKota)
        val btnCek1 = findViewById<Button>(R.id.btnCek1)
        val btnCek2 = findViewById<Button>(R.id.btnCek2)
        val btnCek3 = findViewById<Button>(R.id.btnCek3)

        btnCek1.setOnClickListener{
            cekCuacaHariIni(edtKota.text.toString())
        }
    }

    fun cekCuacaHariIni(kota: String){
        val queue = Volley.newRequestQueue(this)
        val url = "http://api.openweathermap.org/data/2.5/forecast?id=524901&lang={lang}"

        val request = StringRequest(
            Request.Method.GET,
            url,

            Response.Listener<String> { response ->
                val data = JSONObject(response)
                val cuaca = data.getJSONArray("weather").getJSONObject(0).getString("desciption")
                val suhu = data.getJSONObject("main").getDouble("temp")
                val txvHasil1 = findViewById<TextView>(R.id.txvHasil1)
                txvHasil1.text = "${cuaca} (${suhu-273.15}\u2103)"
            },
            Response.ErrorListener {

            })


        btnCek2.setOnClickListener{
            cekCuacaBesok(edtKota.text.toString())
        }
    }

    fun cekCuacaBesok(kota: String){
        val queue = Volley.newRequestQueue(this)
        val url = "http://api.openweathermap.org/data/2.5/forecast?id=524901&lang={lang}"


        val request = StringRequest(
            Request.Method.GET,
            url,

            Response.Listener<String> { response ->
                val data = JSONObject(response)
                val cuaca = data.getJSONArray("weather").getJSONObject(0).getString("desciption")
                val suhu = data.getJSONObject("main").getDouble("temp")
                val txvHasil2 = findViewById<TextView>(R.id.txvHasil2)
                txvHasil2.text = "${cuaca} (${suhu-273.15}\u2103)"
            },
            Response.ErrorListener {

            })

        btnCek3.setOnClickListener{
            cekCuacaHariIni(edtKota.text.toString())
        }
    }

    fun cekCuacaLusa(kota: String){
        val queue = Volley.newRequestQueue(this)
        val url = "http://api.openweathermap.org/data/2.5/forecast?id=524901&lang={}"


        val request = StringRequest(
            Request.Method.GET,
            url,

            Response.Listener<String> { response ->
                val data = JSONObject(response)
                val cuaca = data.getJSONArray("weather").getJSONObject(0).getString("desciption")
                val suhu = data.getJSONObject("main").getDouble("temp")
                val txvHasil3 = findViewById<TextView>(R.id.txvHasil3)
                txvHasil3.text = "${cuaca} (${suhu-273.15}\u2103)"
            },
            Response.ErrorListener {

            })


        queue.add(request)

    }
}