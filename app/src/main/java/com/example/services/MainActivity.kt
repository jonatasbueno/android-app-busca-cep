package com.example.services

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.services.api.HttpClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
  private lateinit var editTextCep: EditText
  private lateinit var textViewInfo: TextView
  private lateinit var buttonSearchRef: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    editTextCep = findViewById(R.id.editTextCep)
    textViewInfo = findViewById(R.id.textViewInfo)
    buttonSearchRef = findViewById(R.id.buttonSearch)

    buttonSearchRef.setOnClickListener {
      val cep = editTextCep.text.toString()

      searchAddressAndName(cep)
    }

  }

  private fun buttonIsEnabled() {
    buttonSearchRef.isEnabled = true
    buttonSearchRef.text = "Buscar"
  }

  private fun searchAddressAndName(cep: String) {
    buttonSearchRef.isEnabled = false
    buttonSearchRef.text = "Buscando..."

    lifecycleScope.launch {
      val httpClient = HttpClient.api

      try {
        val responseAddress = httpClient.getAddress(cep)
        val responseName = httpClient.getName()

        textViewInfo.text = buildString {
          append("Endereço: ")
          append(responseAddress.street)
          append(", ")
          append(responseAddress.neighborhood)
          append(", ")
          append(responseAddress.city)
          append("\nNome de alguém: ")
          append(responseName.name)
        }

        buttonIsEnabled()
      } catch (error: Exception) {
        buttonIsEnabled()
        Toast.makeText(
          this@MainActivity,
          "Erro ao buscar endereço!$error",
          Toast.LENGTH_LONG
        ).show()
      }
    }
  }
}