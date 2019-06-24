package com.example.lentanews.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lentanews.*
import java.util.*


class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val news : ArrayList<RowType> = arrayListOf()
        val headers : ArrayList<RowType> = arrayListOf()
        val mainList : ArrayList<RowType> = arrayListOf(
            HeaderRowType("Top7"),
            NewsRowType("item1"),
            NewsRowType("item2"),
            NewsRowType("item3"),
            NewsRowType("item4"),
            HeaderRowType("Last24"),
            NewsRowType("item1"),
            NewsRowType("item2"),
            NewsRowType("item3"),
            NewsRowType("item4"),
            HeaderRowType("All"),
            NewsRowType("item1"),
            NewsRowType("item2"),
            NewsRowType("item3"),
            NewsRowType("item4")

        )

        val recyclerView: RecyclerView = view!!.findViewById(R.id.main_recycler_view) as RecyclerView
        recyclerView.setHasFixedSize(true)
        val recyclerViewAdapter = RecyclerViewAdapter(mainList)
        recyclerView.adapter = recyclerViewAdapter
        val layoutManager = LinearLayoutManager(this.activity)
        recyclerView.layoutManager = layoutManager


        return view
    }

}