package com.example.kimchiworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.kimchiworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private  var binding:ActivityMainBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding?.root)

    binding?.flStart?.setOnClickListener {
      Toast.makeText(
        this@MainActivity,
        "Here is a button",
        Toast.LENGTH_LONG
      ).show()
    }
  }
  
  override fun onDestroy() { // this on destroy must be added when we use binding
    super.onDestroy()

    binding = null
  }
}