package com.task1.islami.ui

import android.os.Bundle
import android.widget.ImageView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.task1.islami.R
import com.task1.islami.ui.fragments.HeadthFragment
import com.task1.islami.ui.fragments.QuranFragment
import com.task1.islami.ui.fragments.RadioFragment
import com.task1.islami.ui.fragments.SebhaFragment
import java.util.*

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var menuButton: ImageView
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        menuButton = findViewById(R.id.menu_button)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)


        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->

            if (item.itemId == R.id.Quran) {

                pushFragment(QuranFragment())
            } else if (item.itemId == R.id.Headth) {

                pushFragment(HeadthFragment())
            } else if (item.itemId == R.id.Sebha) {

                pushFragment(SebhaFragment())
            } else if (item.itemId == R.id.Radio) {

                pushFragment(RadioFragment())
            }

            return@OnItemSelectedListener true
        })

        bottomNavigationView.selectedItemId = R.id.Quran

        showSideMenu()
        changeMood()
    }

    fun showSideMenu() {
        menuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_Container, fragment)
            .commit()
    }

    fun changeMood() {

        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {

            if (it.itemId == R.id.dark_Mode) {

                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    bottomNavigationView.selectedItemId = R.id.Quran

                } else {

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    bottomNavigationView.selectedItemId = R.id.Quran
                }
            }


            return@OnNavigationItemSelectedListener true
        })

    }

}