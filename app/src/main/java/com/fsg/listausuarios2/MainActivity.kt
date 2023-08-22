package com.fsg.listausuarios2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var editTextNombre: EditText
    lateinit var editTextApellido: EditText
    lateinit var editTextProfesion: EditText
    lateinit var usuarios: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuarios = Intent(this, ListaUsuariosRegistrados::class.java)

        var botonAniadirPulsado: Button = findViewById(R.id.botonAniadir)
        botonAniadirPulsado.setOnClickListener{view -> aniadirUsuario(view)}

        editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        editTextApellido = findViewById<EditText>(R.id.editTextApellido)
        editTextProfesion = findViewById<EditText>(R.id.editTextProfesion)

    }

    fun aniadirUsuarioLista(){

        usuarios.putExtra("Nombre", editTextNombre.text)
        usuarios.putExtra("Apellido", editTextApellido.text)
        usuarios.putExtra("Profesion", editTextProfesion.text)
    }
    fun aniadirUsuario(view: View) {

        var builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Guardar")
        builder.setMessage("Está seguro de que desea guardar los datos")

        var positivoListener = object: DialogInterface.OnClickListener{
            override fun onClick(view: DialogInterface?, p1: Int){
                aniadirUsuarioLista()
            }
        }

        var negativoListenner = object: DialogInterface.OnClickListener{
            override fun onClick(view: DialogInterface?, p1: Int){
                finish()
            }
        }

        builder.setPositiveButton("Si", positivoListener)
        builder.setNegativeButton("No", negativoListenner)
        builder.show()
    }

    fun verLista(view: View) {
        startActivity(usuarios)
}
}