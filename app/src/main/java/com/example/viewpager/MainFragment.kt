package com.example.viewpager

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment(R.layout.fragment_main) {

    private val labelList: ArrayList<String> = arrayListOf("Todo", "Doing", "Done")
    private lateinit var adaptor: ViewPagerAdapter
    private lateinit var title: String
    private lateinit var des: String
    private lateinit var state: String
    private lateinit var model: ViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(this)[ViewModel::class.java]
        adaptor = ViewPagerAdapter(this)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.myViewPager2)
        viewPager2.adapter = adaptor
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(
            tabLayout,
            viewPager2
        ) { tab, position -> tab.text = labelList[position] }.attach()
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val builder = AlertDialog.Builder(context)
            val inflater = requireActivity().layoutInflater;
            val show = inflater.inflate(R.layout.dialog, null)
            val view1 = builder.setView(show)
                .setPositiveButton(
                    R.string.create
                ) { dialog, id ->
                    title = show.findViewById<EditText>(R.id.titled).text.toString()
                    des = show.findViewById<EditText>(R.id.des).text.toString()
                    when (show.findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId) {
                        R.id.radio_doing -> {
                          //  model.doingNameList.add(title)
                          //  model.doingDesList.add(des
                        }
                        R.id.radio_done -> {
                            model.doneNameList.add(title)
                            model.doneDesList.add(des)
                        }
                        R.id.radio_todo -> {
                            val listNAme = mutableListOf<String>()
                            listNAme.add(title)
                            val listDes = mutableListOf<String>()
                            listDes.add(des)
                            ToDo(listNAme,listDes)
                            adaptor.notifyDataSetChanged()
                        }
                    }
                }
                .setNegativeButton(
                    R.string.cancel
                ) { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
            builder.show()
        }
    }
}