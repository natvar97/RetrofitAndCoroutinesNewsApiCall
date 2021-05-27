package com.example.retrofitandcoroutines.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitandcoroutines.R
import com.example.retrofitandcoroutines.model.Articles

class NewsRecyclerAdapter : RecyclerView.Adapter<NewsRecyclerAdapter.NewsRecyclerViewHolder>() {

    private var news = ArrayList<Articles>()

    class NewsRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAuthor = itemView.findViewById<TextView>(R.id.tv_author)
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)
        val tvUrlToNews = itemView.findViewById<TextView>(R.id.tv_url_news)
        val ivImageNews = itemView.findViewById<ImageView>(R.id.iv_image_news)
        val tvPublishedDate = itemView.findViewById<TextView>(R.id.tv_published_date)
        val tvContent = itemView.findViewById<TextView>(R.id.tv_content)

        fun bind(article: Articles) {
            tvAuthor.text = article.author
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvUrlToNews.text = article.url
            tvPublishedDate.text = article.publishedAt
            tvContent.text = article.content
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .fitCenter()
                .into(ivImageNews)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NewsRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsRecyclerViewHolder, position: Int) {
        holder.bind(news[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW , Uri.parse(news[position].url))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }

    fun addAll(list: List<Articles>) {
        news.addAll(list)
        notifyDataSetChanged()
    }

}