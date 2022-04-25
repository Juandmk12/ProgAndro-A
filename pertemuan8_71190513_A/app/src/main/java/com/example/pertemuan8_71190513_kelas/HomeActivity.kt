package com.example.pertemuan8_71190513_kelas

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.ListFragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(findViewById(R.id.toolbar_default))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val pager = findViewById<ViewPager2>(R.id.pager)

        val listFragment: ArrayList<Fragment> = arrayListOf(SatuFragment(), DuaFragment(), TigaFragment())

        val pagerAdapter = PagerAdapter(this, listFragment)

        pager.adapter = pagerAdapter

        setSupportActionBar(findViewById(R.id.toolbar_default))
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    class PagerAdapter( val activity: AppCompatActivity, val listFragment: ArrayList<Fragment>) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = listFragment.size

        override fun createFragment(position: Int): Fragment = listFragment[position]


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_default, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.love -> {
            Toast.makeText(this,"Like",Toast.LENGTH_LONG).show()
            val viewPagerProfile = findViewById<ViewPager2>(R.id.pager)
            viewPagerProfile.setCurrentItem(1)
            true
        }
        R.id.message -> {
            Toast.makeText(this,"Message",Toast.LENGTH_LONG).show()
            val viewPagerSetting = findViewById<ViewPager2>(R.id.pager)
            viewPagerSetting.setCurrentItem(2)
            true
        }
        R.id.setting -> {
            Toast.makeText(this,"Setting",Toast.LENGTH_LONG).show()
            val viewPagerCamera = findViewById<ViewPager2>(R.id.pager)
            viewPagerCamera.setCurrentItem(0)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

}