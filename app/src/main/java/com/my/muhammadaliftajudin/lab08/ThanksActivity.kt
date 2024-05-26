package com.my.muhammadaliftajudin.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.muhammadaliftajudin.lab08.databinding.ActivityThanksBinding

class ThanksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThanksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThanksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Components
        val nameTextView = binding.nameTextView;
        val phoneTextView = binding.phoneTextView;

        nameTextView.text = intent.getStringExtra("name")
        phoneTextView.text = intent.getStringExtra("phone")
    }
}