package com.example.resepmakanan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)

        // Pengambilan data dari Intent
        val name = intent.getStringExtra("name")
        val time = intent.getStringExtra("time")
        val ingredients = intent.getStringExtra("ingredients")
        val process = intent.getStringExtra("process")
        val imageResourceId = intent.getIntExtra("imageResourceId", 0)

        // Ambil referensi ke view
        val nameTextView = findViewById<TextView>(R.id.detailName)
        val timeTextView = findViewById<TextView>(R.id.detailTime)
        val ingredientsTextView = findViewById<TextView>(R.id.detailIngredients)
        val processTextView = findViewById<TextView>(R.id.detailProcess)
        val imageView = findViewById<ImageView>(R.id.detailImage)

        // Setel data ke view
        nameTextView.text = name
        timeTextView.text = time
        ingredientsTextView.text = ingredients
        processTextView.text = process
        imageView.setImageResource(imageResourceId)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}