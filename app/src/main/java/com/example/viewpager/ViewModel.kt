package com.example.viewpager

import androidx.lifecycle.ViewModel

class ViewModel:ViewModel() {
    var toDoNameList = mutableListOf<String>()
    val toDoDesList = mutableListOf<String>()

    var doingNameList = mutableListOf<String>()
    val doingDesList = mutableListOf<String>()

    var doneNameList = mutableListOf<String>()
    var doneDesList = mutableListOf<String>()
}