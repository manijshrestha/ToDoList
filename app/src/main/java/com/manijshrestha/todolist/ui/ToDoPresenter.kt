package com.manijshrestha.todolist.ui

import com.manijshrestha.todolist.data.Task
import com.manijshrestha.todolist.data.TaskDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ToDoPresenter @Inject constructor(val taskDao: TaskDao) {

    val compositeDisposable = CompositeDisposable()
    var tasks = ArrayList<Task>()

    var presentation: ToDoPresentation? = null

    fun onCreate(toDoPresentation: ToDoPresentation) {
        presentation = toDoPresentation
        loadTasks()
    }

    fun onDestroy() {
        compositeDisposable.dispose()
        presentation = null
    }

    fun loadTasks() {
        compositeDisposable.add(taskDao.getAllTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tasks.clear()
                    tasks.addAll(it)
                    (tasks.size - 1).takeIf { it >= 0 }?.let {
                        presentation?.taskAddedAt(it)
                        presentation?.scrollTo(it)
                    }
                }))

        presentation?.showTasks(tasks)
    }

    fun addNewTask(taskDescription: String) {
        val newTask = Task(description = taskDescription)
        compositeDisposable.add(Observable.fromCallable { taskDao.insertTask(newTask) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }
}