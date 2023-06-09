package com.example.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                ToDo(mutableListOf(), mutableListOf())
            }
            1 -> {
                Doing()
            }
            2 -> {
                Done()
            }
            else -> {
                ToDo(mutableListOf(), mutableListOf())
            }
        }
    }
}