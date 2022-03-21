package com.example.pertemuan6_71190513_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_second, container, false)
        val btnSecond = v.findViewById<Button>(R.id.btnFirst)
        btnSecond.setOnClickListener {
            Toast.makeText(context, "menuju First Fragment", Toast.LENGTH_LONG).show()
        }

        return v
    }
}