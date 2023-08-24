package com.fsg.listausuarios2

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback.DismissEvent
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    val listaUsuarios = ArrayList<DataItem>()

    private val REQUEST_IMAGE_CAPTURE = 1
    private val PERMISSION_REQUEST_CODE = 101
    private var bitmapPhoto : Bitmap? = null
    lateinit var imageViewPhoto : ImageView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageViewPhoto = findViewById(R.id.imageViewFoto);
    }

    fun aniadirUsuario(view: View) {

        var builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Guardar")
        builder.setMessage("Está seguro de que desea guardar los datos")

        var positivoListener = object: DialogInterface.OnClickListener{
            override fun onClick(view: DialogInterface?, p1: Int){
                var editTextNombre = findViewById<EditText>(R.id.editTextNombre)
                var editTextApellido = findViewById<EditText>(R.id.editTextApellido)
                var editTextProfesion = findViewById<EditText>(R.id.editTextProfesion)

                listaUsuarios.add(DataItem("${editTextNombre.text}", "${editTextApellido.text}", "${editTextProfesion.text}"))
            }
        }

        var negativoListenner = object: DialogInterface.OnClickListener{
            override fun onClick(view: DialogInterface?, p1: Int){
                DismissEvent()
            }
        }

        builder.setPositiveButton("Si", positivoListener)
        builder.setNegativeButton("No", negativoListenner)
        builder.show()
    }

    fun verLista(view: View) {
        var usuarios = Intent(this, ListaUsuariosRegistrados::class.java)
        var gson = Gson()
        var data = gson.toJson(listaUsuarios)

        usuarios.putExtra("Data", data)
        startActivity(usuarios)
}
    fun takePicture(view: View) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==  PackageManager.PERMISSION_GRANTED) {
            takePicture();
        }
        else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                PERMISSION_REQUEST_CODE
            )
        }
    }

    private fun takePicture() {
        val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    takePicture()

                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }

            else -> {

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                bitmapPhoto = data!!.extras!!.get("data") as Bitmap
                imageViewPhoto.setImageBitmap(bitmapPhoto)
            }

        }
    }
}