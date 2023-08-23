package com.fsg.listausuarios2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.get

class MiAdapter (private val activity: Activity, private val listaUsuarios: ArrayList<DataItem>)
    : BaseAdapter(){
        class ViewHolder {
            lateinit var textViewNombre: TextView
            lateinit var textViewApellido: TextView
            lateinit var textViewProfesion: TextView

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

             viewHolder.textViewNombre = filaView.findViewById<TextView>(R.id.editTextNombre)
             viewHolder.textViewApellido = filaView.findViewById<TextView>(R.id.editTextApellido)
             viewHolder.textViewProfesion= filaView.findViewById<TextView>(R.id.editTextProfesion)

            viewHolder.textViewNombre.text = listaUsuarios[indice].nombre
            viewHolder.textViewApellido.text = listaUsuarios[indice].apellido
            viewHolder.textViewProfesion.text = listaUsuarios[indice].profesion

            filaView.tag = viewHolder

            return filaView
        }

    }
