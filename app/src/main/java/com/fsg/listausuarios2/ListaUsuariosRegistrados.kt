package com.fsg.listausuarios2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ListView
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken

class ListaUsuariosRegistrados : AppCompatActivity() {

    var listaUsuarios: ArrayList<DataItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios_registrados)

        val listViewUsuarios: ListView = findViewById(R.id.listViewUsuarios)
        val miAdaptador = MiAdapter(this, listaUsuarios)

        var gson = Gson()

        val itemType = object : TypeToken<ArrayList<DataItem>>() {}.type
        var data = intent.getStringExtra("Datos")
        var lista2:ArrayList<DataItem> = gson.fromJson(data, itemType)

        listViewUsuarios
        //elementos()

    }
   /* fun elementos(){
        var listViewUsuarios = findViewById<ListView>(R.id.listViewUsuarios)

        var data = intent.getStringArrayListExtra("Datos")




    }*/
    }
