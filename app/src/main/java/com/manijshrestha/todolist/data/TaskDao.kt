package com.manijshrestha.todolist.data

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao interface TaskDao {

    @Query("select * from task")
    fun getAllTasks(): List<Task>

    @Query("select * from task where id = :p0")
    fun findTaskById(id: Long): Task

    @Insert(onConflict = REPLACE)
    fun insertTask(task: Task)

    @Update(onConflict = REPLACE)
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}