package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SplashFragment())
            .commit()


        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, UserListFragment())
                .commit()
        }, 5000)

    }

}