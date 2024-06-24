package com.example.proyectofinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectofinal.R
import com.example.proyectofinal.model.basicInfo.servant.Servant

class ServantFullInfoAdapter (private var servants: List<Servant>) : RecyclerView.Adapter<ServantFullInfoAdapter.ServantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_servantfullinfo, parent, false)
        return ServantViewHolder(view)
    }




    override fun onBindViewHolder(holder: ServantViewHolder, position: Int) {
        //VOVLER A ESTO SI NO VA
        val servant = servants[position]

        holder.bindFullInfo(servant)

        //QUITAR SI NO VA
        //holder.bind(servants[position], clickListener)
    }

    fun updateServants(newServants: List<Servant>) {
        servants = newServants
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = servants.size


    inner class ServantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageFullView: ImageView = itemView.findViewById(R.id.ivFullInfoImage)
        private val nameFullTextView: TextView = itemView.findViewById(R.id.tvServantFullInfoName)
        private val rarityFullTextView: RatingBar = itemView.findViewById(R.id.rbRarity)
        private val classFullTextView: TextView = itemView.findViewById(R.id.tvServantFullInfoClass)
        private val collectionNoFullTextView: TextView = itemView.findViewById(R.id.tvServantFullInfoNoCollection)
        private val originalName: TextView = itemView.findViewById(R.id.tvFullInfoOriginalName)
        private val type: TextView = itemView.findViewById(R.id.tvFullInfoType)
        private val classId: TextView = itemView.findViewById(R.id.tvFullInfoClassId)
        private val attribute: TextView = itemView.findViewById(R.id.tvFullInfoAttribute)
        private val hpMax: TextView = itemView.findViewById(R.id.tvFullInfoHpMax)
        private val atkMax: TextView = itemView.findViewById(R.id.tvFullInfoAtkMax)



        fun bindFullInfo(servant: Servant) {


            nameFullTextView.text = servant.name
            rarityFullTextView.rating = servant.rarity.toFloat()
            classFullTextView.text = servant.className
            collectionNoFullTextView.text = servant.collectionNo.toString()
            originalName.text = servant.originalName
            type.text = servant.type
            classId.text = servant.classId.toString()
            attribute.text = servant.attribute
            hpMax.text = servant.hpMax.toString()
            atkMax.text = servant.atkMax.toString()

            servant.face?.let { url ->
                Glide.with(itemView.context)
                    .load(servant.face)
                    .placeholder(R.drawable.ic_download)
                    .error(R.drawable.ic_error)
                    .override(200, 200)
                    .into(imageFullView)
            }
        }




    }



}