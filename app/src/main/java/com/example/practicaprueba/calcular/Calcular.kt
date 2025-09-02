package com.example.practicaprueba.calcular

object Calcular {

    fun sumar(valor1 : Int, valor2 : Int): Int {
        return  try {
            valor1 + valor2
        }catch (e: ArithmeticException) {
            println("ERRROR")
            0
        }finally {
            println("Finally")
        }



    }

}