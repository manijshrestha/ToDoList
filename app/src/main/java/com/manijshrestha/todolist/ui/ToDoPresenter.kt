package com.manijshrestha.todolist.ui

import com.manijshrestha.todolist.model.Task
import javax.inject.Inject

class ToDoPresenter @Inject constructor() {

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
        presentation?.showTasks(tasks)
    }

    fun addNewTask(taskDescription: String) {
        tasks.add(Task(description = taskDescription))

        (tasks.size - 1).let {
            presentation?.taskAddedAt(it)
            presentation?.scrollTo(it)
        }
    }
}