package com.example.uas_71190513_a

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.example.uas_71190513_a.R
import com.example.uas_71190513_a.databinding.ActivityProfileBinding
import com.example.uas_71190513_a.fragments.HomeFragment
import com.example.uas_71190513_a.fragments.ProfileFragment
import com.example.uas_71190513_a.fragments.SearchFragment

class ProfileActivity : AppCompatActivity() {

    private val profileFragment = ProfileFragment()
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        replaceFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_profile -> replaceFragment(profileFragment)
                R.id.ic_search -> replaceFragment(searchFragment)
            }
            true
        }
    }



    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}