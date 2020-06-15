package com.example.converter_currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var currencyRates: MutableMap<String, Double> = mutableMapOf("Dollar" to 1.0, "Ruble" to 0.014, "Euro" to 1.13, "Grivna" to 0.038, "Pound" to 1.26, "Yuan" to 0.14)
        button.setOnClickListener {
            var et: EditText = findViewById(R.id.editText1)
            var rawdata = et.text.toString()
            var data = rawdata.toDouble()
            var rawvivod: Double = 1.0
            var vivod = ""
            var etc: EditText = findViewById(R.id.editText2)
            var spinner1: Spinner = findViewById(R.id.spinner1)
            var spinner2: Spinner = findViewById(R.id.spinner2)
            var selected1: String = spinner1.selectedItem.toString()
            var selected2: String = spinner2.selectedItem.toString()
            var coefficient1: Double = 0.0
            var coefficient2: Double = 0.0
            for((key, value) in currencyRates) {
                if(key==selected1) {
                    coefficient1 = value
                }
            }
            for((key, value) in currencyRates) {
                if(key==selected2) {
                    coefficient2 = value
                }
            }
            rawvivod = data*coefficient1
            rawvivod = rawvivod/coefficient2
            vivod = rawvivod.toString()
            etc.setText(vivod)
        }
    }
}
