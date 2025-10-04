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

      searchAddress(cep)
    }

  }

  private fun searchAddress(cep: String) {
    lifecycleScope.launch {
      try {
        val response = HttpClient.api.getAddress(cep, TOKEN)

        textViewInfo.text = response.toString()
      } catch (error: Exception) {
        Toast.makeText(
          this@MainActivity,
          "Erro ao buscar endereço!$error",
          Toast.LENGTH_LONG
        ).show()
      }
    }
  }
}