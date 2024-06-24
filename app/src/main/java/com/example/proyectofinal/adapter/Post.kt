package com.example.proyectofinal.adapter

import com.bumptech.glide.annotation.Excludes
import com.google.firebase.firestore.Exclude
import java.sql.Date

class Post(val post: String? = null, val date: java.util.Date? = null, val userName: String? = null, val likes: ArrayList<String>? = arrayListOf()) {

    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null

    constructor(): this(null, null, null, null)



}