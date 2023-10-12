package com.example.avoid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        database = FirebaseDatabase.getInstance().getReference("user")
        supportActionBar?.hide()
        val name = findViewById<EditText>(R.id.name)
        val id = findViewById<EditText>(R.id.id)
        val email = findViewById<EditText>(R.id.mail)
        val password = findViewById<EditText>(R.id.pass)
        val sign = findViewById<Button>(R.id.up)
        sign.setOnClickListener {
            val userName = name.text.toString()
            val id1 = id.text.toString()
            val mail = email.text.toString()
            val pass = password.text.toString()
            if (userName.isNotEmpty() && id1.isNotEmpty() && mail.isNotEmpty() && pass.isNotEmpty()) {
                database.child(id1).setValue(users(userName, id1, mail, pass))
                    .addOnSuccessListener {
                        name.text.clear()
                        id.text.clear()
                        email.text.clear()
                        password.text.clear()
                        Toast.makeText(
                            this,
                            "User Added Sucessfully!! please Sign In",
                            Toast.LENGTH_LONG
                        ).show()
                    }.addOnFailureListener {
                        Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                    }
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_LONG).show()
            }
        }
        val text = findViewById<TextView>(R.id.text)
        text.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}