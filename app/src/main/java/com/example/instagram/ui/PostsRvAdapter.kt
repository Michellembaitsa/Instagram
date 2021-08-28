package com.example.instagram.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R


class PostsRvAdapter(var postList:List<Post>, var context: Context): RecyclerView.Adapter<ViewHolderPost>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
        return  ViewHolderPost(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        var currentPost=postList.get(position)
        holder.tvId.text=currentPost.id.toString()
        holder.ivImage.text=currentPost.
        holder.cvPosts.setOnClickListener {
            var intent= Intent(context,ViewPostActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
class ViewHolderPost(itemView: View): RecyclerView.ViewHolder(itemView) {
    var tvId = itemView.findViewById<TextView>(R.id.tvId)
    var ivImage = itemView.findViewById<ImageView>(R.id.ivImage)
    var tvCaption = itemView.findViewById<TextView>(R.id.tvCaption)
    var cvPosts = itemView.findViewById<CardView>(R.id.cvPosts)
}

