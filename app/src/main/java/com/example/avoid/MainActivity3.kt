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
import org.w3c.dom.Text

class MainActivity3 : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar?.hide()

        val id = findViewById<EditText>(R.id.userId)
        val text = findViewById<TextView>(R.id.text)
        val pass = findViewById<EditText>(R.id.password1)
        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener{
            val id1 = id.text.toString()
            val pass1 = pass.text.toString()
            if(id1.isNotEmpty()&&pass1.isNotEmpty()) {
                database = FirebaseDatabase.getInstance().getReference("user")
                database.child(id1).get().addOnSuccessListener {
                    if (it.exists()) {
                        val password = it.child("password").value
                        if (password == pass1) {
                            val intent = Intent(this, MainActivity4::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Incorrect Password", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this, "User does not exist", Toast.LENGTH_LONG).show()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"Please enter all fields", Toast.LENGTH_LONG).show()
            }
        }
        text.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}