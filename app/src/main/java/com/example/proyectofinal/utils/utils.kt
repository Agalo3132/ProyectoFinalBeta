package com.example.proyectofinal.utils

import android.content.Context
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.proyectofinal.R

fun cargaImagen(ivImagen: ImageView, uri:String) {
    Glide
        .with(ivImagen.getContext())
        //url de la imagen
        .load(uri)
        //centramos la imagen
        // .centerCrop()
        //mientras se carga la imagen que imagen queremos mostrar
        //crea los iconos de placeholder y error
        .placeholder(R.drawable.ic_download)
        //Imagen que mostramos si hay error
        .error(R.drawable.ic_error)
        //donde colocamos la imagen
        .into(ivImagen);
}

fun showError(context: Context, message: String) {
    AlertDialog.Builder(context).apply {
        setTitle("Error")
        setMessage(message)
        setPositiveButton("Accept", null)
    }.show()
}
