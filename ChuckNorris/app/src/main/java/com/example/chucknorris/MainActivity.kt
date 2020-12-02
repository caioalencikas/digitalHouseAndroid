package com.example.chucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorris.view.CategoryFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, CategoryFragment())
            .commit()
    }

}