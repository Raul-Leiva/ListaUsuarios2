package com.fsg.listausuarios2

import android.widget.EditText

class DataItem {
    var nombreUsuario: String
    var apellidoUsuario: String
    var profesionUsuario: String

    constructor(nombreUsuario: String, apellidoUsuario: String, profesionUsuario: String) {

        this.nombreUsuario = nombreUsuario
        this.apellidoUsuario = apellidoUsuario
        this.profesionUsuario = profesionUsuario
    }
}
