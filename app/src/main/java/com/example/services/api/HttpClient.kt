package com.example.services.api

import com.example.services.Constants.URL
import com.example.services.InvertextoAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient {

  // Singleton
  private val retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(URL)
      // converte JSON com a lib GSON
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  // API criada "preguiçosamente", só na primeira chamada
  val api: InvertextoAPI by lazy {
    retrofit.create(InvertextoAPI::class.java)
  }
}
