package com.example.proyectofinal.adapter

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class PostAdapter(private val activity: Activity, private val dataset: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private val auth = FirebaseAuth.getInstance()

    private val db = FirebaseFirestore.getInstance()



    class ViewHolder (val layout: View) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.card_post, parent, false)

        return ViewHolder(layout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = dataset[position]
        val likes = post.likes!!.toMutableList()
        var liked = likes.contains(auth.uid)

        holder.layout.findViewById<TextView>(R.id.tvPost).text = post.post
        holder.layout.findViewById<TextView>(R.id.tvNamePerson).text = post.userName

        holder.layout.findViewById<TextView>(R.id.tvLikes).text = "${likes.size} likes"

        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault())

        holder.layout.findViewById<TextView>(R.id.tvFecha).text = sdf.format(post.date ?: Date())
        setColor(liked, holder.layout.findViewById<Button>(R.id.btLike))


        holder.layout.findViewById<Button>(R.id.btLike).setOnClickListener {
            liked = !liked
            setColor(liked, holder.layout.findViewById<Button>(R.id.btLike))

            if (liked) likes.add(auth.uid!!)
            else likes.remove(auth.uid)

            val doc = db.collection("posts").document(post.uid!!)

            db.runTransaction {
                it.update(doc, "likes", likes)

                null
            }

        }

        holder.layout.findViewById<Button>(R.id.btPost).setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, post.post)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            activity.startActivity(shareIntent)

        }

        if (post.userName == auth.currentUser!!.displayName!!) {

            holder.layout.setOnLongClickListener {

                AlertDialog.Builder(activity).apply {
                    setTitle("Delete Post")
                    setMessage("Are you sure you want to delete this post?")
                    setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                        db.collection("posts").document(post.uid!!).delete()
                            .addOnSuccessListener {

                            }.addOnFailureListener {
                                AlertDialog.Builder(activity).apply {
                                    setTitle("Error")
                                    setMessage(it.message)
                                    setPositiveButton("Accept", null)
                                }.show()
                            }

                    }
                    setNegativeButton("No", null)



                }.show()



                true
            }





        }



    }

    private fun setColor(liked: Boolean, likeButton: Button) {
        if (liked) likeButton.setTextColor(ContextCompat.getColor(activity, R.color.purple_500))
        else likeButton.setTextColor(ContextCompat.getColor(activity, R.color.white))
    }


}