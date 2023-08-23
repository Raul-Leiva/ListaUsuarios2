package com.fsg.listausuarios2

import android.text.Editable
import android.widget.EditText

data class DataItem(val nombre: String, val apellido: String, val profesion: String) {

    var nombreUsuario= nombre
    var apellidoUsuario= apellido
    var profesionUsuario= profesion

    fun pasarString():String{
       return nombre + "#" + apellido + "#" + profesion
    }
    fun pasarData(valor:String):DataItem{
        var atributos = valor.split("#")
        return  DataItem(atributos[0], atributos[1], atributos[2])
    }
}

