package com.example.todolist.db

import androidx.lifecycle.LiveData
import com.example.todolist.model.TaskModel

//class TaskRealization(private val taskDao: TaskDao): TaskRepository
//{
//    override val allNotes: List<TaskModel>
//        get() = taskDao.getAllTasks()
//
//    override fun insertTask(taskModel: TaskModel, onSuccess: () -> Unit) {
//        taskDao.insert(taskModel)
//        onSuccess()
//    }
//
//    override fun deleteTask(taskModel: TaskModel, onSuccess: () -> Unit) {
//        taskDao.delete(taskModel)
//        onSuccess()
//    }
//
//    override fun updateTask(taskModel: TaskModel, onSuccess: () -> Unit) {
//        taskDao.updateTask(taskModel)
//        onSuccess()
//    }
//}