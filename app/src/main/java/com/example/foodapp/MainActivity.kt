package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.ActivityMainBinding

private  lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        binding.bootomNavBar.setOnItemSelectedListener {
            when (it) {
                R.id.nav_home -> replaceFragment(Home())
                R.id.nav_profile -> {
                    replaceFragment(Profile())
                    binding.bootomNavBar.showBadge(R.id.nav_cart)
                }
                R.id.nav_near -> replaceFragment(Nearby())
                R.id.nav_cart -> {
                    binding.bootomNavBar.dismissBadge(R.id.nav_cart)
                    replaceFragment(Cart())
                }
                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager =supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}


/*
            when(it){
                R.id.nav_near -> binding.textMain.text ="Nearby"
                R.id.nav_home -> binding.textMain.text="Home"
                R.id.nav_cart ->{
                    binding.textMain.text="Cart"
                    binding.bootomNavBar.dismissBadge(R.id.nav_cart)
                }
                R.id.nav_account ->{
                    binding.textMain.text ="Offers"
                    binding.bootomNavBar.showBadge(R.id.nav_cart)
                }

            }
            */