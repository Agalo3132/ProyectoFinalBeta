package com.example.proyectofinal.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.ItemServantBinding
import com.example.proyectofinal.model.basicInfo.servant.Servant

//SI NO VA QUITAR EL LISTENER -> UNIT
class ServantAdapter (private var servants: List<Servant>, private val listener: OnItemClickListener) : RecyclerView.Adapter<ServantAdapter.ServantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_servant, parent, false)
        return ServantViewHolder(view)
    }

    var clickListener: OnServantClickListener?=null
    lateinit var listaServant: List<Servant>
    lateinit var servantAdapter: ServantAdapter

    interface OnItemClickListener {
        fun onItemClick()
    }

    override fun onBindViewHolder(holder: ServantViewHolder, position: Int) {
        //VOVLER A ESTO SI NO VA
        val servant = servants[position]
        holder.bind(servant, listener)

        //QUITAR SI NO VA
        //holder.bind(servants[position], clickListener)
    }

    fun updateServants(newServants: List<Servant>) {
        servants = newServants
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = servants.size

    interface OnServantClickListener {
        fun onServantClick(servant: Servant?)
    }


    inner class ServantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.ivServantImage)
        private val nameTextView: TextView = itemView.findViewById(R.id.tvServantNombreCard)
        private val rarityTextView: TextView = itemView.findViewById(R.id.tvServantRarityCard)
        private val classTextView: TextView = itemView.findViewById(R.id.tvClassNameCard)
        private val collectionNoTextView: TextView = itemView.findViewById(R.id.tvServantCollectionNoCard)
        private var str: String? = null


        //QUITAR clickListener si no va
        fun bind(servant: Servant, listener: OnItemClickListener) {


            nameTextView.text = servant.name
            rarityTextView.text = servant.rarity.toString()
            classTextView.text = servant.className
            collectionNoTextView.text = servant.collectionNo.toString()

            servant.face?.let { url ->
                Glide.with(itemView.context)
                    .load(servant.face)
                    .placeholder(R.drawable.ic_download)
                    .error(R.drawable.ic_error)
                    .override(200, 200)
                    .into(imageView)
            }


            itemView.setOnClickListener {
                listener.onItemClick()
            }


        }



    }



}