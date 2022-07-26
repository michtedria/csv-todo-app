package com.cognizant.android.tasktodoapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cognizant.android.tasktodoapp.databinding.ItemTasksBinding
import com.cognizant.android.tasktodoapp.model.Tasks

class TaskAdapter(
    private val dataset: List<Tasks>
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(val binding: ItemTasksBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val adapterLayout = ItemTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = dataset[position]
            holder.itemView.apply {
                with(holder.binding) {
                   tvTitle.text = item.title
                }
                setOnClickListener {
                    Log.d("Text", item.title)
                    onItemClickListener?.let {
                        it(item)
                    }
                }
            }
        }

    override fun getItemCount(): Int {
        return dataset.size
    }

    private var onItemClickListener: ((Tasks) -> Unit)? = null
    fun  setOnItemClickListener(listener: (Tasks) -> Unit) {
        onItemClickListener = listener
    }



 }