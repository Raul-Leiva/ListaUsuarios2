package com.fsg.listausuarios2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView

class ListaUsuariosRegistrados : AppCompatActivity() {

    var listaUsuarios: ArrayList<DataItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios_registrados)

        elementos()
    }
    fun elementos(){
        val nombre = intent.getStringExtra("Nombre")
        val apellido = intent.getStringExtra("Apellido")
        val profesion = intent.getStringExtra("Profesion")

        listaUsuarios.add(DataItem("$nombre", "$apellido", "$profesion"))

    }
}