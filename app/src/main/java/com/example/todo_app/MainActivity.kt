package com.example.todo_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerview)
        val add: Button = findViewById(R.id.ADD)
        val newTodo:EditText = findViewById(R.id.new_todo)


        var todoList = mutableListOf(
            TodoData("Learn Recyclerview",true),
            TodoData("Did you have your breakfast",false),
            TodoData("Have you tasted the curry",false),
            TodoData("I Love Android",true),
            TodoData("Do you have a GirlFriend",false),
            TodoData("Do you Watch Anime",true),
            TodoData("Do you love horror movies",true),
            TodoData("Wanna say bye",false)
        )

        val adapter = TodoAdapter(todoList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            val title = newTodo.text.toString()
            val todo = TodoData(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }

    }
}