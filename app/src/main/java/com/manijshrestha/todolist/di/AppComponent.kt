package com.manijshrestha.todolist.di

import com.manijshrestha.todolist.ToDoApplication
import dagger.Component

@Component(modules = arrayOf(AppModule::class,
        ToDoModule::class))
interface AppComponent {

    fun inject(application: ToDoApplication)
}