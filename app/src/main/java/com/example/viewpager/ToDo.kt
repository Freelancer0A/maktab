package com.example.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ToDo(var nl: MutableList<String>, var dl: MutableList<String>) :
    Fragment(R.layout.fragment_to_do) {
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.toDoRecycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val adapter = RecyclerAdapter(
            nl as ArrayList<String>,
            dl as ArrayList<String>
        )
        recyclerView.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }
}