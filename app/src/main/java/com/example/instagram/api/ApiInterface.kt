package com.example.instagram.api

interface ApiInterface {
    fun getPosts(): Call<List<Post>>

}