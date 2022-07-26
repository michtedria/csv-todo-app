package com.cognizant.android.tasktodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cognizant.android.tasktodoapp.SecondActivity.Companion.EXTRA_MESSAGE
import com.cognizant.android.tasktodoapp.databinding.ActivitySecondBinding
import com.cognizant.android.tasktodoapp.databinding.ActivityThirdBinding
import com.cognizant.android.tasktodoapp.model.Tasks

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val task = intent.getParcelableExtra<Tasks>(EXTRA_MESSAGE)
        task?.let {
            with(binding) {
                val newTitle = it.title
                val newDetails = it.details
                tvTitle2.text = newTitle
                tvDetails.text = newDetails
            }
        }
    }
    companion object {
        const val EXTRA_MESSAGE = "MESSAGE"
    }
}