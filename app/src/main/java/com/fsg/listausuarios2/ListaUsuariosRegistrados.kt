package com.fsg.listausuarios2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ListView
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken

class ListaUsuariosRegistrados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios_registrados)

        var listViewUsuarios: ListView = findViewById(R.id.listViewUsuarios)

        var gson = Gson()
        val itemType = object : TypeToken<ArrayList<DataItem>>() {}.type
        var data = intent.getStringExtra("Data")
        var lista2: ArrayList<DataItem> = gson.fromJson(data, itemType)

        val miAdaptador = MiAdapter(this, lista2)

        listViewUsuarios.adapter = miAdaptador

    }
    }
