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
        val sizeTextView = binding.sizeTextView;
        val pickupDateTextView = binding.pickupDateTextView;
        val pickupTimeTextView = binding.pickupTimeTextView;
        val ratingButton = binding.ratingBtn;
        val ratingBar = binding.ratingBar;
        val ratingTextView = binding.ratingTextView;

        nameTextView.text = intent.getStringExtra("name")
        phoneTextView.text = intent.getStringExtra("phone")
        sizeTextView.text = intent.getStringExtra("size")
        pickupDateTextView.text = intent.getStringExtra("date")
        pickupTimeTextView.text = intent.getStringExtra("time")
        
        ratingButton.setOnClickListener {
            ratingTextView.text = ratingBar.rating.toString();
        }

    }
}