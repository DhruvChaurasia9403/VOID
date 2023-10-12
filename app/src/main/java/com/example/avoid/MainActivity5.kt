package com.example.avoid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        supportActionBar?.hide()
        val card = findViewById<CardView>(R.id.cardView1)
        card.setOnClickListener{
            val intent = Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
    }
}