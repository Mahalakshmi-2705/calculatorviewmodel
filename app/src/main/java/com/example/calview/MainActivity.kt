package com.example.calview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Using viewModels() extension function from the activity-ktx library
    private val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button click listeners
        binding.btnAdd.setOnClickListener { performOperation("+") }
        binding.btnSubtract.setOnClickListener { performOperation("-") }
        binding.btnMultiply.setOnClickListener { performOperation("*") }
        binding.btnDivide.setOnClickListener { performOperation("/") }

        // Observe the result from the ViewModel
        calculatorViewModel.result.observe(this, Observer {
            binding.txtResult.text = it
        })
    }

    private fun performOperation(operator: String) {
        val num1 = binding.edtNumber1.text.toString().toDoubleOrNull() ?: 0.0
        val num2 = binding.edtNumber2.text.toString().toDoubleOrNull() ?: 0.0

        when (operator) {
            "+" -> calculatorViewModel.add(num1, num2)
            "-" -> calculatorViewModel.subtract(num1, num2)
            "*" -> calculatorViewModel.multiply(num1, num2)
            "/" -> calculatorViewModel.divide(num1, num2)
        }
    }
}
