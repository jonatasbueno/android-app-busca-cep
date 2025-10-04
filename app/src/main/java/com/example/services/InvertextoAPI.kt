  package com.example.services

  import com.example.services.model.Address
  import retrofit2.http.GET
  import retrofit2.http.Path
  import retrofit2.http.Query

  interface InvertextoAPI {
    @GET("vi/cep/{cep}")
    suspend fun getAddress(
      @Path("cep") cep: String,
      @Query("token") token: String
    ): Address
  }