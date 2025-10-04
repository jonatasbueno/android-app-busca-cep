package com.example.services.model

data class Address (
    private val cep: String,
    private val state: String,
    private val city: String,
    private val neighborhood: String,
    private val street: String,
    private val complement: String,
    private val ibge: String
)