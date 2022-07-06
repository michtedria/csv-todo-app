package com.cognizant.android.tasktodoapp.datasource

import android.content.Intent
import androidx.annotation.StringRes
import com.cognizant.android.tasktodoapp.R
import com.cognizant.android.tasktodoapp.model.Tasks

class Datasource(){

    fun loadTasks(): List<Tasks> {
        return listOf<Tasks> (
            Tasks(R.string.task1),
            Tasks(R.string.task2),
//            Tasks(R.string.EXTRA_MESSAGE)
        )
    }
}