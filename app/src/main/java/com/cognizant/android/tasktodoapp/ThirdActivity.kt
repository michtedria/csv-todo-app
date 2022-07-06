package com.cognizant.android.tasktodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cognizant.android.tasktodoapp.SecondActivity.Companion.EXTRA_MESSAGE
import com.cognizant.android.tasktodoapp.databinding.ActivitySecondBinding
import com.cognizant.android.tasktodoapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle2.text = intent.getStringExtra(EXTRA_MESSAGE)
    }
}