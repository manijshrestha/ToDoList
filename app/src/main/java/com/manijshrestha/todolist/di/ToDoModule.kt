package com.manijshrestha.todolist.di

import android.app.Activity
import com.manijshrestha.todolist.ui.ToDoActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ToDoSubComponent::class))
abstract class ToDoModule {

    @Binds
    @IntoMap
    @ActivityKey(ToDoActivity::class)
    internal abstract fun bindsToDoActivityInjectorFactory(builder: ToDoSubComponent.Builder): AndroidInjector.Factory<out Activity>
}