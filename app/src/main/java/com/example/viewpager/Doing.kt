package com.example.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recyclerView: RecyclerView

class Doing : Fragment(R.layout.fragment_doing) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model = ViewModelProvider(requireActivity())[ViewModel::class.java]
        recyclerView = view.findViewById(R.id.doing_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        val adapter = RecyclerAdapter(model.doingNameList as ArrayList<String>,model.doingDesList as ArrayList<String>)
        recyclerView.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }
}
