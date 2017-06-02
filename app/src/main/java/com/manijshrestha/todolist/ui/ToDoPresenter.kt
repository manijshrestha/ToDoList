package com.manijshrestha.todolist.ui

import com.manijshrestha.todolist.data.Task
import com.manijshrestha.todolist.data.TaskDao
import javax.inject.Inject

class ToDoPresenter @Inject constructor(val taskDao: TaskDao) {

    var tasks = ArrayList<Task>()

    var presentation: ToDoPresentation? = null

    fun onCreate(toDoPresentation: ToDoPresentation) {
        presentation = toDoPresentation
        loadTasks()
    }

    fun onDestroy() {
        presentation = null
    }

    fun loadTasks() {
        tasks.clear()
        tasks.addAll(taskDao.getAllTasks())
        presentation?.showTasks(tasks)
    }

    fun addNewTask(taskDescription: String) {
        val newTask = Task(description = taskDescription)
        tasks.add(newTask)
        taskDao.insertTask(newTask)
        (tasks.size - 1).let {
            presentation?.taskAddedAt(it)
            presentation?.scrollTo(it)
        }
    }
}