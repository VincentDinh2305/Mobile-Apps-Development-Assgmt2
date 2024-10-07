package com.example.DinhHoangVietPhuong_COMP304Sec001_Lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterBtn = findViewById<Button>(R.id.enter_btn);

        enterBtn.setOnClickListener {

            intent = Intent(applicationContext,HomeSelectActivity::class.java)

            startActivity(intent)
        }
    }
}