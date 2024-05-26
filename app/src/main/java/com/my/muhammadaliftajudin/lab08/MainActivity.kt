package com.my.muhammadaliftajudin.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.muhammadaliftajudin.lab08.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Date Button
        var dateButton = binding.dateBtn;
        var timeButton = binding.timeBtn;
        var dateTextView = binding.dateTextView;
        var timeTextView = binding.timeTextView;

        dateButton.setOnClickListener {
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker = DatePickerDialog(this, android.R.style.ThemeOverlay,
                DatePickerDialog.OnDateSetListener { DatePicker, Year, Month, Day ->
                    dateTextView.text = "$Day/${Month + 1}/$Year"}, year, month, day)
            myDatePicker.show()
        }

        timeButton.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR)
            val minutes = c.get(Calendar.MINUTE)
            
            val myTimePicker = TimePickerDialog(this, android.R.style.ThemeOverlay,
                TimePickerDialog.OnTimeSetListener { TimePicker, hourOfDay, minute ->
                    timeTextView.text = "$hourOfDay:$minute"}, hour, minutes, true)
            myTimePicker.show()
        }
    }
}