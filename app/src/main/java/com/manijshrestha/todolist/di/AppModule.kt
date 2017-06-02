package com.manijshrestha.todolist.di

import android.arch.persistence.room.Room
import android.content.Context
import com.manijshrestha.todolist.data.AppDatabase
import dagger.Module
import dagger.Provides

@Module class AppModule(private val context: Context) {

    @Provides fun providesAppContext() = context

    @Provides fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-todo-db").build()

    @Provides fun providesToDoDao(database: AppDatabase) = database.taskDao()
}