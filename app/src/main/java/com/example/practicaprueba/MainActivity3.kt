package com.example.practicaprueba

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaprueba.conversor.Conversor

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val numeroConvertor:TextView = findViewById(R.id.txtConversor)
            val botonConvertir:Button = findViewById(R.id.btnConversor)
            val textoResultado:TextView = findViewById(R.id.txtTotal)

            botonConvertir.setOnClickListener{

                val numeroUno = numeroConvertor.text.toString().toIntOrNull() ?:0

                var resultado = Conversor.convertir_usd_string(numeroUno)
                textoResultado.text = resultado.toString()
            }



            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}