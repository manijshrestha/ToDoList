package com.manijshrestha.todolist.ui

import com.manijshrestha.todolist.data.Task

class TaskAdapter(var tasks: List<Task>) : android.support.v7.widget.RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: android.view.ViewGroup, type: Int): com.manijshrestha.todolist.ui.TaskAdapter.TaskViewHolder {
        return TaskViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: com.manijshrestha.todolist.ui.TaskAdapter.TaskViewHolder, position: Int) {
        viewHolder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(parent: android.view.ViewGroup) : android.support.v7.widget.RecyclerView.ViewHolder(android.view.LayoutInflater.from(parent.context).inflate(com.manijshrestha.todolist.R.layout.item_to_do, parent, false)) {

        fun bind(task: Task) = with(itemView) {
            val taskCb = findViewById(com.manijshrestha.todolist.R.id.task_cb) as android.widget.CheckBox
            taskCb.text = task.description
            taskCb.isChecked = task.completed
        }
    }
}