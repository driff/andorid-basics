package com.fif.tech.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.textView5).text = "DF3"
        findViewById<Button>(R.id.button).setOnClickListener {
//            Toast.makeText(this, "Hola Mundo", Toast.LENGTH_LONG).show()
            Snackbar.make(findViewById(R.id.parent), "Hola Mundo", Snackbar.LENGTH_LONG).show()
        }
    }
}