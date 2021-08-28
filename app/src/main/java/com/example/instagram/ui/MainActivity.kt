package com.example.instagram.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram.R
import com.example.instagram.api.ApiClient
import com.example.instagram.api.ApiInterface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }
    fun getPosts(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response:
            Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext, "${posts!!.size} posts", Toast.
                    LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })
    }
}