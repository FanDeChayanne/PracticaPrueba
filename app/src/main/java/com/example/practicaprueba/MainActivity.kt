package com.example.practicaprueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializacion de variables
        val edUsername:TextView = findViewById(R.id.txtUsername)
        val edPasswod:TextView = findViewById(R.id.txtPassword)
        val btnLogin:Button = findViewById(R.id.buttonLogin)
        val msjLogin:TextView = findViewById(R.id.txtView)

        //Datos a comparar para login
        var usuarioBase = "admin"
        var passBase = "admin123"


        btnLogin.setOnClickListener{
            if (edUsername.text.toString() == usuarioBase.toString() && edPasswod.text.toString() == passBase.toString() ){

                // se crea el objeto Intent
                val nuevaVentana = Intent(this, MainActivity2::class.java)


                var ses_username = edUsername.text.toString()

                nuevaVentana.putExtra("sesion", ses_username)
                nuevaVentana.putExtra("par_contraseña", edPasswod.text.toString() )

                // se abe el Intent ya creado
                startActivity(nuevaVentana)

                val toast = Toast.makeText(this,"Bienvenid@s", Toast.LENGTH_LONG)

                toast.show()

                msjLogin.text = "Login Ok"


            }else{
                msjLogin.text = "Login NO"
            }

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}