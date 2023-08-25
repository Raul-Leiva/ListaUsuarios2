package com.fsg.listausuarios2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class Custom: DialogFragment() {

    lateinit var editTextNombre: EditText
    lateinit var editTextApellido: EditText
    lateinit var editTextProfesion: EditText

    lateinit var editTextNombre2: EditText
    lateinit var editTextApellido2: EditText
    lateinit var editTextProfesion2: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View? {

        var viewDialog = inflater.inflate(R.layout.custom_dialog, container)
        var viewDialogMain = inflater.inflate(R.layout.activity_main, container)


        editTextNombre = viewDialog.findViewById(R.id.editTextNombreEdit)
        editTextApellido = viewDialog.findViewById(R.id.editTextApellidoEdit)
        editTextProfesion = viewDialog.findViewById(R.id.editTextProfesionEdit)

        editTextNombre2 = viewDialogMain.findViewById(R.id.editTextNombre)
        editTextApellido2 = viewDialogMain.findViewById(R.id.editTextApellido)
        editTextProfesion = viewDialogMain.findViewById(R.id.editTextProfesion)

        var botonCancelar = viewDialog.findViewById<Button>(R.id.botonCancelar)
        botonCancelar.setOnClickListener { view -> cancelar() }

        var botonAceptar = viewDialog.findViewById<Button>(R.id.botonAceptar)
        botonAceptar.setOnClickListener { view -> aceptar() }

        return viewDialog

    }
    fun cancelar(){
        dismiss()
    }
    fun aceptar(){
        editTextNombre2.text = editTextNombre.text
        editTextApellido2.text = editTextApellido.text
        editTextProfesion2.text = editTextProfesion.text
    }
}