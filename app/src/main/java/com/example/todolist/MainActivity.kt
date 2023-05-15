package com.example.todolist

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.*
import com.example.todolist.adapter.TaskAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.db.TaskDao
import com.example.todolist.db.TaskDatabase
import com.example.todolist.model.TaskModel
import java.util.UUID
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    var adapter = TaskAdapter()
    var lastId = 0;

    var curList =  ArrayList<TaskModel>()

    lateinit var db: TaskDatabase
    lateinit var taskDao: TaskDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MAIN = this
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        adapter.setList(curList)

        db = Room.databaseBuilder(applicationContext, TaskDatabase::class.java, "db").allowMainThreadQueries().build()
        taskDao= db.getTaskDao()

        initList()

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun initList()
    {
        val tasks: List<TaskModel> = taskDao.getAllTasks()

        for (curTask in tasks)
        {
            curList.add(curTask)
        }

        lastId = curList.last().id + 1
    }

    fun onAdd(task: TaskModel)
    {
        task.id = lastId
        lastId++
        taskDao.insert(task)
        curList.add(task)
        adapter.setList(curList)

        val tasks: List<TaskModel> = taskDao.getAllTasks()
        println(task.id)
        println("List of tasks:")
        for (task in tasks)
        {
            println(task.id)
            println(task.textOfTask)
        }
    }
}