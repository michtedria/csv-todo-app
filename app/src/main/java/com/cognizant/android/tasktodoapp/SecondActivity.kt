package com.cognizant.android.tasktodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cognizant.android.tasktodoapp.databinding.ActivitySecondBinding
import com.cognizant.android.tasktodoapp.datasource.DataObject

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btsubmit.setOnClickListener {
                val title = etTitle.text.toString()
                val details = etDetails.text.toString()
                DataObject.setData(title, details)
            submitTask()
            }
        }
    }

    private fun submitTask() {
        val intent = Intent(this@SecondActivity, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "MESSAGE"
    }
}