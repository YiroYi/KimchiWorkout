package com.example.kimchiworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kimchiworkout.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
  private var binding: ActivityHistoryBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityHistoryBinding.inflate(layoutInflater)
    setContentView(binding?.root)

    setSupportActionBar(binding?.toolbarHistoryActivity)
      if(supportActionBar != null) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //set back button
        supportActionBar?.title = "HISTORY" // Setting a title in the action bar.
      }

      binding?.toolbarHistoryActivity?.setNavigationOnClickListener {
        onBackPressed()
      }
  }
}