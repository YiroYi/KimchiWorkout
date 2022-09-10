package com.example.kimchiworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.kimchiworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
  private var binding:ActivityExerciseBinding? = null

  private var restTimer: CountDownTimer? = null
  private var restProgress = 0


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding  = ActivityExerciseBinding.inflate(layoutInflater)
    setContentView(binding?.root)

    setSupportActionBar(binding?.toolbarExercise)

    if(supportActionBar != null) {
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    binding?.toolbarExercise?.setNavigationOnClickListener {
      onBackPressed()
    }

    setupRestView()

  }

  private fun setupRestView() {
    if(restTimer != null) {
      restTimer?.cancel()
      restProgress = 0
    }

    setRestProgressBar()
  }

  private fun setRestProgressBar() {
    binding?.progressBar?.progress =restProgress

    restTimer = object: CountDownTimer(10000, 1000) {
      override fun onTick(p0: Long) {
        restProgress++
        binding?.progressBar?.progress = 10 - restProgress
        binding?.tvTimer?.text = (10 - restProgress).toString()
      }

      override fun onFinish() {
        Toast.makeText(
          this@ExerciseActivity,
          "Here now we will start the exercise.",
          Toast.LENGTH_LONG
        ).show()
      }

    }.start()
  }

  override fun onDestroy() { // this on destroy must be added when we use binding
    // This happens when the view is destroyed or we move to another one
    super.onDestroy()

    if(restTimer != null) {
      restTimer?.cancel()
      restProgress = 0
    }
    binding = null
  }
}