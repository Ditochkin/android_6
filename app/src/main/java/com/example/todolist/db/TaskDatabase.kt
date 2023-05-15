package com.example.todolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.model.TaskModel

@Database(entities = [TaskModel::class], version = 2)
abstract class TaskDatabase : RoomDatabase()
{
    abstract fun getTaskDao(): TaskDao

    companion object{
        private var database: TaskDatabase ?= null

        @Synchronized
        fun getInstance(context: Context):TaskDatabase{
            return if (database == null)
            {
                database = Room.databaseBuilder(context, TaskDatabase::class.java, "db").build()
                database as TaskDatabase
            }
            else
            {
                database as TaskDatabase
            }
        }
    }
}