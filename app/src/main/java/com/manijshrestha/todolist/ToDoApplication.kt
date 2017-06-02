package com.manijshrestha.todolist

import android.app.Activity
import android.app.Application
import com.manijshrestha.todolist.di.AppComponent
import com.manijshrestha.todolist.di.AppModule
import com.manijshrestha.todolist.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ToDoApplication : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()

        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}