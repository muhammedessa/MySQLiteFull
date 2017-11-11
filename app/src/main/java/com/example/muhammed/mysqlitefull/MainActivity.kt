package com.example.muhammed.mysqlitefull

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btn : Button
    lateinit var btn2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.databaseBtn)
        btn2 = findViewById(R.id.insertDB)


        btn.setOnClickListener {
            val intent = Intent(this,Database2Activity::class.java)
            startActivity(intent)

        }

        btn2.setOnClickListener {
            val intent = Intent(this,Insert2Activity::class.java)
            startActivity(intent)

        }


    }
}
