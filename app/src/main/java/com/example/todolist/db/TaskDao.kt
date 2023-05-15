package com.example.todolist.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.model.TaskModel

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(taskModel: TaskModel)

    @Delete
    fun delete(taskModel: TaskModel)

    @Query("SELECT * from tasks")
    fun getAllTasks(): List<TaskModel>

    @Update
    fun updateTask(task: TaskModel)
}