package com.example.trainproj

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.trainproj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ivPoster = findViewById<ImageView>(R.id.ivPoster)

        ivPoster.setOnClickListener {
            Toast.makeText(this@MainActivity, "нажали на картинку", Toast.LENGTH_SHORT).show()
            //Intent(this@MainActivity, SecondActivity::class.java).also { startActivity(it) }
            val url = Uri.parse("https://ya.ru")
            Intent(Intent.ACTION_VIEW, url).also { startActivity(it) }
        }

        binding.btnDisplay.setOnClickListener {
            Intent(this@MainActivity, SecondActivity::class.java).also { startActivity(it) }
        }

        binding.btnShare.setOnClickListener {
            val msg = "Привет. Андроид разработка - это круто!"
            val shareIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("d4nssd@yandex.com"))
                putExtra(Intent.EXTRA_TEXT, msg)
                putExtra("qwe", 1)
            }
            startActivity(shareIntent)
        }
    }
    //new merge
    // 1234556498
}