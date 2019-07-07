package com.example.lentanews.rowtypes

import android.support.v7.widget.RecyclerView
import com.example.lentanews.async.DownloadImage
import com.example.lentanews.RecyclerViewHolders


class NewsHorizontalRowType(private val tittle: String, private val description: String, private val imageUrl: String, val link: String) : RowType {

    override fun getItemViewType(): Int {

        return RowType.NEWS_HORIZONTAL_ROW_TYPE
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val textViewHolder = viewHolder as RecyclerViewHolders.NewsHorizontalViewHolder
        val getImage = DownloadImage(textViewHolder.imageView)
        getImage.execute(imageUrl)
        textViewHolder.click(link)
        textViewHolder.textTittleHoriz.text = tittle
        textViewHolder.textDescriptionHoriz.text = description
    }
}