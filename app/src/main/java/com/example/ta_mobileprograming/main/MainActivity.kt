package com.example.ta_mobileprograming.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ta_mobileprograming.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button= findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent (this@MainActivity,Jadwal::class.java)
            startActivity(intent)

        }
        val button1= findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent (this@MainActivity,Pribadi::class.java)
            startActivity(intent)

        }




    }

    }
