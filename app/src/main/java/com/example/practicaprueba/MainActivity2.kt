package com.example.practicaprueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaprueba.calcular.Calcular
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val primerNumero:TextView = findViewById(R.id.firstNumber)
        val segundoNumero:TextView = findViewById(R.id.secondNumber)
        val botonCalcular:Button = findViewById(R.id.buttonCalculator)
        val textoResultado:TextView = findViewById(R.id.txtResult)

        val btnIrConversor:Button = findViewById(R.id.btnConversor)


        botonCalcular.setOnClickListener{
            val valorUno: Int = primerNumero.text.toString().toIntOrNull() ?: 0
            val valorDos: Int = segundoNumero.text.toString().toIntOrNull() ?: 0

            var resultado = Calcular.sumar(valorDos, valorDos)
            textoResultado.text = resultado.toString()


        }


        btnIrConversor.setOnClickListener{

            val ventanaConversor = Intent(this, MainActivity3::class.java)

            startActivity(ventanaConversor)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}