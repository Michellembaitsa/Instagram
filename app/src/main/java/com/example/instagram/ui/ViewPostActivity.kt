package com.example.instagram.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.R
import com.example.instagram.api.ApiClient
import com.example.instagram.api.ApiInterface

class ViewPostActivity : AppCompatActivity() {
    var postId=0
lateinit var tvId:TextView
lateinit var ivImage:ImageView
lateinit var tvCaption:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvId=findViewById(R.id.tvId)
        ivImage=findViewById(R.id.ivImage)
        tvCaption=findViewById(R.id.tvCaption)



   fetchPostById()
    }
    fun fetchPostById(){
        var apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post=response.body()
                    tvId.text=post?.title
                    ivImage.url=post?.body
                    tvCaption.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}