package com.task1.islami.api

import com.task1.islami.model.AudiosResponse
import retrofit2.http.GET

interface WepServices {

      @GET("radio_ar.json")
      suspend fun getAudios():AudiosResponse
}