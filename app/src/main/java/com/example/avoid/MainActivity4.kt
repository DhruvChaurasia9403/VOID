package com.example.avoid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        supportActionBar?.hide()
        val card = findViewById<CardView>(R.id.cardView1)
        val card1 = findViewById<CardView>(R.id.cardView2)
        val card2 = findViewById<CardView>(R.id.cardView3)
        card1.setOnClickListener{
            Toast.makeText(this,"This feature is not available", Toast.LENGTH_SHORT).show()
        }
        card2.setOnClickListener{
            Toast.makeText(this,"This feature is not available", Toast.LENGTH_SHORT).show()
        }
        card.setOnClickListener{
            val intent = Intent(this,MainActivity5::class.java)
            startActivity(intent)
        }
    }
}