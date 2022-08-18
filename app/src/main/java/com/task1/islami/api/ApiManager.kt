package com.task1.islami.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object {

        private var retrofit: Retrofit? = null

        private fun getInstance(): Retrofit {

            if (retrofit == null) {

                val logging = HttpLoggingInterceptor { message -> Log.e("Api", message) }
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

                retrofit =
                    Retrofit.Builder().client(client).baseUrl("https://www.mp3quran.net/api/radio/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit!!
        }


        public fun getApis(): WepServices {

            return getInstance().create(WepServices::class.java)
        }
    }
}
