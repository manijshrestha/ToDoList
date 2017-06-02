package com.manijshrestha.todolist.di

import com.manijshrestha.todolist.ui.ToDoActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent interface ToDoSubComponent : AndroidInjector<ToDoActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ToDoActivity>()
}