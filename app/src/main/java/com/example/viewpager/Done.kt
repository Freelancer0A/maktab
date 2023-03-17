package com.example.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recyclerView: RecyclerView

class Done : Fragment(R.layout.fragment_done) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model = ViewModelProvider(requireActivity())[ViewModel::class.java]
        recyclerView = view.findViewById(R.id.done_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        val adapter = RecyclerAdapter(model.doneNameList as ArrayList<String>,model.doneDesList as ArrayList<String>)
        recyclerView.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }
}