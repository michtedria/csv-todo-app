package com.cognizant.android.tasktodoapp.adapter

import android.content.Context
import android.content.Intent
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cognizant.android.tasktodoapp.R
import com.cognizant.android.tasktodoapp.datasource.Datasource
import com.cognizant.android.tasktodoapp.model.Tasks

class TasksAdapter(
    private val context: Context,
    private val dataset: List<Tasks>
): RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
    class TaskViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tasks, parent, false)

        return TaskViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

 }