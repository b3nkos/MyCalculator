package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var lastNumeric = false
    private var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        val button = view as Button
        textViewInput.append(button.text)
        lastNumeric = true

        textViewInput.text.contains("")
    }

    fun onClear(view: View) {
        textViewInput.text = ""
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View) {
        if (!lastNumeric) return
        if (lastDot) return

        textViewInput.append(".")
        lastNumeric = false
        lastDot = true
    }

    fun onOperator(view: View) {
        if (!lastNumeric) return
        if (isOperatorAdded(textViewInput.text.toString())) return

        val button = view as Button
        textViewInput.append(button.text)
        lastNumeric = false
        lastDot = false
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*")
                    || value.contains("+") || value.contains("-")
        }
    }
}