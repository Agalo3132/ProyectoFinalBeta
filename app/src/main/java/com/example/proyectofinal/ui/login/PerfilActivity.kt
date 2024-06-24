package com.example.proyectofinal.ui.login

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.ActivityPerfilBinding
import com.example.proyectofinal.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btEditProfile.setOnClickListener {
            val email = binding.etNewEmail.text.toString()
            val password = binding.etNewPassword.text.toString()
            val name = binding.etNewUsername.text.toString()
            val image = binding.ivNewPhoto.drawable

            val user = auth.currentUser

            if (user != null) {
                val userUpdate = UserProfileChangeRequest.Builder().setDisplayName(name).build()

                user.updateProfile(userUpdate)
                    .addOnSuccessListener {
                        user.verifyBeforeUpdateEmail(email)
                    }.addOnFailureListener {
                        AlertDialog.Builder(this).apply {
                            setTitle("Error")
                            setMessage(it.message)
                            setPositiveButton("Accept", null)
                        }.show()
                    }.addOnSuccessListener {
                        user.updatePassword(password)
                    }.addOnFailureListener {
                        AlertDialog.Builder(this).apply {
                            setTitle("Error")
                            setMessage(it.message)
                            setPositiveButton("Accept", null)
                        }.show()
                    }.addOnSuccessListener {
                        AlertDialog.Builder(this).apply {
                            setTitle("Success")
                            setMessage("Profile updated")
                            setPositiveButton("Accept") { _: DialogInterface, _: Int ->
                                finish()
                            }
                        }.show()
                    }.addOnFailureListener {
                        AlertDialog.Builder(this).apply {
                            setTitle("Error")
                            setMessage(it.message)
                            setPositiveButton("Accept", null)
                        }.show()
                    }


            }

            /**
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    val profile = UserProfileChangeRequest.Builder().setDisplayName(name).build()

                    it.user!!.updateProfile(profile)
                        .addOnSuccessListener {
                            AlertDialog.Builder(this).apply {
                                setTitle("Success")
                                setMessage("User created")
                                setPositiveButton("Accept") { _: DialogInterface, _: Int ->
                                    finish()
                                }
                            }.show()

                        }
                        .addOnFailureListener{
                            AlertDialog.Builder(this).apply {
                                setTitle("Error")
                                setMessage(it.message)
                                setPositiveButton("Accept", null)
                            }.show()
                        }

                }
                .addOnFailureListener {
                    AlertDialog.Builder(this).apply {
                        setTitle("Error")
                        setMessage(it.message)
                        setPositiveButton("Accept", null)
                    }.show()
                }
            **/

        }



    }






}