package com.fsg.listausuarios2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText

class MiAdapter (private val activity: Activity, private val listaUsuarios: ArrayList<DataItem>)
    : BaseAdapter(){
        class ViewHolder {
            lateinit var editTextNombre: EditText
            lateinit var editTextApellido: EditText
            lateinit var editTextProfesion: EditText
        }

        override fun getCount(): Int {
            return listaUsuarios.size
        }

        override fun getItem(p0: Int): Any {
            return listaUsuarios[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(indice: Int, view: View?, p2: ViewGroup?): View {
            var filaView = view
            var viewHolder = ViewHolder()

                val inflater = activity.layoutInflater
                filaView = inflater.inflate(R.layout.activity_lista_usuarios_registrados, null, true)



            return filaView!!
        }

    }
