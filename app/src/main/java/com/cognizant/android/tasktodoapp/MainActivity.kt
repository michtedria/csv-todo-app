package com.cognizant.android.tasktodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cognizant.android.tasktodoapp.adapter.TaskAdapter
import com.cognizant.android.tasktodoapp.databinding.ActivityMainBinding
import com.cognizant.android.tasktodoapp.datasource.DataObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val myDataset = DataObject.loadTasks()
            val adapterTask = TaskAdapter(myDataset)
            adapterTask.setOnItemClickListener {
                Log.d("test", it.title)
                val intent = Intent(this@MainActivity, ThirdActivity::class.java).apply {
                    putExtra(ThirdActivity.EXTRA_MESSAGE, it)
                }
                startActivity(intent)
            }

            recyclerView.apply {
                adapter = adapterTask
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
            }
            fatClick.setOnClickListener {
                gotoNextPage()
            }
        }
    }

    private fun gotoNextPage() {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "MESSAGE"
    }
}
