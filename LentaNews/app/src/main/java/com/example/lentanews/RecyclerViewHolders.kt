package com.example.lentanews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.widget.TextView import android.view.View
import android.widget.Button
import com.example.lentanews.fragments.MainFragment
import com.example.lentanews.fragments.NewsListFragment


class ViewHolders {

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var headerTextView: TextView
        var button: Button

        init {
            headerTextView = itemView.findViewById(R.id.headers)
            button = itemView.findViewById(R.id.buttonView) as Button
            button.setOnClickListener(View.OnClickListener { onClick(itemView)})
        }

        fun onClick(v: View) {
            val bundle = Bundle()
            bundle.putString("header", headerTextView.text as String?)
            val newsListFragment = NewsListFragment()
            newsListFragment.setArguments(bundle)
            val activity = v.context as AppCompatActivity

            activity.getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container,
                newsListFragment
            ).addToBackStack(null).commit()
        }

    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView1: TextView

        init {
            textView1 = itemView.findViewById(R.id.textView1)
        }

    }

    fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            RowType.HEADER_ROW_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_headers, parent, false)
                return HeaderViewHolder(view)
            }

            RowType.NEWS_ROW_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_news, parent, false)
                return NewsViewHolder(view)
            }
            else ->  {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_news, parent, false)
                return NewsViewHolder(view)
            }
        }
    }
}