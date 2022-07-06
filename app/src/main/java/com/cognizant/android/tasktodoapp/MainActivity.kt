package com.cognizant.android.tasktodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cognizant.android.tasktodoapp.adapter.TasksAdapter
import com.cognizant.android.tasktodoapp.databinding.ActivityMainBinding
import com.cognizant.android.tasktodoapp.datasource.Datasource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Log.d(LOG_TAG, "Hello from Main Activity")

        val with = with(binding) {
            tvSubject.text = "To Do list"
            fatClick.setOnClickListener {
                gotoNextPage()
            }

            val myDataset = Datasource().loadTasks()

            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.apply {
                adapter = TasksAdapter(this@MainActivity, myDataset)
//                layoutManager = LinearLayoutManager(this@MainActivity)
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
 //               layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)

                recyclerView.addOnItemTouchListener(RecyclerItemClickListener(this@MainActivity, recyclerView, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        displayTaskPage()
                    }
                    override fun onItemLongClick(view: View?, position: Int) {
                      //  Toast.makeText(, "", Toast.LENGTH_SHORT).show()
                    }
                }))
            }
        }
    }

    private fun displayTaskPage() {
        val intent = Intent(this@MainActivity, ThirdActivity::class.java)
            startActivity(intent)
    }

    private fun gotoNextPage() {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
    }

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName
        const val EXTRA_MESSAGE = "MESSAGE"
    }
}
