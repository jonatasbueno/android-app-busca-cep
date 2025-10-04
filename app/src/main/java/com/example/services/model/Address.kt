package com.example.services.model

data class Address(
  val cep: String,
  val state: String,
  val city: String,
  val neighborhood: String,
  val street: String,
  val complement: String,
  val ibge: String,
)