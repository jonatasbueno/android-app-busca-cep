package com.example.services

import com.example.services.Constants.API_TOKEN
import com.example.services.model.Address
import com.example.services.model.Name
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InvertextoAPI {
  @GET("v1/cep/{cep}")
  suspend fun getAddress(
    @Path("cep") cep: String,
    @Query("token") token: String = API_TOKEN,
  ): Address

  @GET("v1/faker")
  suspend fun getName(
    @Query("token") token: String = API_TOKEN,
    @Query("fields") fields: String = "name",
  ): Name
}