package com.example.kimchiworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kimchiworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
  private var binding: ActivityBmiBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityBmiBinding.inflate(layoutInflater)
    setContentView(binding?.root)

    setSupportActionBar(binding?.toolbarBmiActivity)


    if(supportActionBar != null) {
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
      supportActionBar?.title = "Calculate BMI"
    }

    binding?.toolbarBmiActivity?.setNavigationOnClickListener {
      onBackPressed()
    }

    binding?.btnCalculateUnits?.setOnClickListener {
      if(validateMetricUnits()) {
        val heightValue : Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
        val weightValue : Float = binding?.etMetricUnitWeight?.text.toString().toFloat()

        val bmi = weightValue / (heightValue * heightValue)

        displayBMIResults(bmi)

      } else {
        Toast.makeText(
          this@BMIActivity,
          "Please enter valid values",
          Toast.LENGTH_LONG
        ).show()
      }
    }
  }

  private fun displayBMIResults(bmi: Float) {
    val bmiLabel : String
    val bmiDescription : String

    if(bmi.compareTo(15f) <= 0) {
      bmiLabel = "Very several underweight"
      bmiDescription = "Oops take care of you"
    } else if(bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0) {
      bmiLabel = "Eat more"
      bmiDescription = "Oops take care of you"
    } else if(bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0) {
      bmiLabel = "Weight Missing"
      bmiDescription = "Oops take care of you"
    } else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
      bmiLabel = "Normal"
      bmiDescription = "Very good"
    }else if(bmi.compareTo(25f) > 0 && bmi.compareTo(35f) <= 0) {
      bmiLabel = "fat"
      bmiDescription = "Very good"
    } else {
      bmiLabel = "Super Fat"
      bmiDescription = "Stop Eating"
    }

    val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

    binding?.llDisplayBMIResult?.visibility =  View.VISIBLE
    binding?.tvBMIValue?.text = bmiValue
    binding?.tvBMIType?.text = bmiLabel
    binding?.tvDescription?.text = bmiDescription


  }

  private fun validateMetricUnits(): Boolean {
    var isValid = true

    if(binding?.etMetricUnitWeight?.text.toString().isEmpty()) {
      isValid = false
    } else if (binding?.etMetricUnitHeight?.text.toString().isEmpty()){
      isValid = false
    }

    return isValid
  }
}