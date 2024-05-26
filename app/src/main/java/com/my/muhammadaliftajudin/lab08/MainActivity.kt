package com.my.muhammadaliftajudin.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
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
        
        // Components
        var dateButton = binding.dateBtn;
        var timeButton = binding.timeBtn;
        var scheduleButton = binding.scheduleBtn;
        var pizzaSeekbar = binding.pizzaSeekBar;
        var pizzaSizeTextView = binding.pizzaSizeTextView;
        var dateTextView = binding.dateTextView;
        var timeTextView = binding.timeTextView;
        var nameEditText = binding.nameEditText;
        var phoneEditText = binding.phoneEditText;

        // Variables
        val pizzaSizes = arrayOf("Please Select Size", "Small", "Medium", "Large", "Extra Large")

        // Action Seekbar
        pizzaSeekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                pizzaSizeTextView.text = pizzaSizes[progress]
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })



        // Action Date Button
//        dateButton.setOnClickListener {
//            val c = Calendar.getInstance()
//            val day = c.get(Calendar.DAY_OF_MONTH)
//            val month = c.get(Calendar.MONTH)
//            val year = c.get(Calendar.YEAR)
//
//            // Date Picker dialog 6 argument
//            val myDatePicker = DatePickerDialog(this,
//                android.R.style.ThemeOverlay,
//                DatePickerDialog.OnDateSetListener { DatePicker, year, month, dayOfMonth ->
//                    dateTextView.text = "$dayOfMonth/$month/$year"
//                },
//                year,
//                month,
//                day)
//            myDatePicker.show()
//        }



        dateButton.setOnClickListener {
            val myCalendar = Calendar.getInstance()

            val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                // Set value to text view
                dateTextView.text = "$dayOfMonth/$month/$year";
            }

            DatePickerDialog(
                this,
                datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        // Action Time Button
        timeButton.setOnClickListener {
            val myCalendar = Calendar.getInstance()

            val timePicker = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                myCalendar.set(Calendar.MINUTE, minute)

                // Set value to text view
                timeTextView.text = "$hourOfDay:$minute"
            }

            TimePickerDialog(
                this,
                timePicker,
                myCalendar.get(Calendar.HOUR_OF_DAY),
                myCalendar.get(Calendar.MINUTE),
                true).show()
        }

        // Action Schedule Button
        scheduleButton.setOnClickListener {
            // create a new intent / new page
            val intent = Intent(this, ThanksActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("phone", phoneEditText.text.toString())
            startActivity(intent)
        }
    }
}