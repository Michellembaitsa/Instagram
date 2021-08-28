package com.example.instagram.api

object ApiClient {
    object ApiClient {
        var retrofit = Retrofit.Builder()
            .baseUrl("http://13.244.243.129/photos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        fun <T> buildApiClient(apiInterface: Class<T>): T {
            return retrofit.create(apiInterface)
        }
    }
}
