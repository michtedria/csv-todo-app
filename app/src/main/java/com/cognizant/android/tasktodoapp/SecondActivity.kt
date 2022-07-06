package com.cognizant.android.tasktodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import com.cognizant.android.tasktodoapp.SecondActivity.Companion.EXTRA_MESSAGE
import com.cognizant.android.tasktodoapp.databinding.ActivitySecondBinding
import com.cognizant.android.tasktodoapp.datasource.Datasource

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btsubmit.setOnClickListener {
            submitTask()
        }


    }

    private fun submitTask() {
        val intent = Intent().apply {
            putExtra(MainActivity.EXTRA_MESSAGE, binding.etTitle.text.toString())
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    companion object {
        const val EXTRA_MESSAGE = "MESSAGE"
    }
}