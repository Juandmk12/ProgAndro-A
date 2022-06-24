package com.example.uas_71190513_a

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.uas_71190513_a.databinding.ActivityCRUDBinding
import com.example.uas_71190513_a.fragments.HomeFragment

class ActivityCRUD: AppCompatActivity() {
    private lateinit var binding : ActivityCRUDBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCRUDBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val judul = binding.tiJudul.text.toString()
            val tahun = binding.tiTahun.text.toString()
            val genre = binding.tiGenre.text.toString()
            val duration = binding.tiDuration.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Movie")
            val movieId = database.push().key.toString()
            val Movie = Movie(movieId,judul,tahun,genre,duration)
            database.child(movieId).setValue(Movie).addOnSuccessListener {
                binding.tiJudul.text?.clear()
                binding.tiTahun.text?.clear()
                binding.tiGenre.text?.clear()
                binding.tiDuration.text?.clear()

                Toast.makeText(this,"Sukses Tersimpan", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)

            }.addOnFailureListener{
                Toast.makeText(this,"Gagal Tersimpan", Toast.LENGTH_SHORT).show()

            }


        }
    }
}