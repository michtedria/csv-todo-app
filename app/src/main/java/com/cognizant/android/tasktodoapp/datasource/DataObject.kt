package com.cognizant.android.tasktodoapp.datasource

import com.cognizant.android.tasktodoapp.R
import com.cognizant.android.tasktodoapp.model.Tasks

object DataObject {

    var listTask = mutableListOf<Tasks> ()

    fun loadTasks(): List<Tasks> {
        return listTask
    }

    fun setData(title: String, details: String) {
        listTask.add(Tasks(title, details))
    }
}