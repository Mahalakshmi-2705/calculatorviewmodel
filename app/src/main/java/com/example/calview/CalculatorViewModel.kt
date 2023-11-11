package com.example.calview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    // MutableLiveData to observe the result
    val result = MutableLiveData<String>()

    // Perform addition
    fun add(firstNumber: Double, secondNumber: Double) {
        result.value = (firstNumber + secondNumber).toString()
    }

    // Perform subtraction
    fun subtract(firstNumber: Double, secondNumber: Double) {
        result.value = (firstNumber - secondNumber).toString()
    }

    // Perform multiplication
    fun multiply(firstNumber: Double, secondNumber: Double) {
        result.value = (firstNumber * secondNumber).toString()
    }

    // Perform division
    fun divide(firstNumber: Double, secondNumber: Double) {
        if (secondNumber != 0.0) {
            result.value = (firstNumber / secondNumber).toString()
        } else {
            result.value = "Error"
        }
    }
}
