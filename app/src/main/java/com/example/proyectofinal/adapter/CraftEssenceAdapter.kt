package com.example.proyectofinal.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectofinal.R
import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode
import com.example.proyectofinal.model.basicInfo.craftEssence.CraftEssence

class CraftEssenceAdapter (private var craftEssences: List<CraftEssence>) : RecyclerView.Adapter<CraftEssenceAdapter.CraftEssenceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CraftEssenceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_servant, parent, false)
        return CraftEssenceViewHolder(view)
    }

    override fun getItemCount(): Int = craftEssences.size

    fun updateCommandCodes(newCraftEssences: List<CraftEssence>) {
        craftEssences = newCraftEssences
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CraftEssenceViewHolder, position: Int) {
        val craftEssence = craftEssences[position]
        holder.bind(craftEssence)
    }


    inner class CraftEssenceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.ivServantImage)
        private val nameTextView: TextView = itemView.findViewById(R.id.tvServantNombreCard)
        private val rarityTextView: TextView = itemView.findViewById(R.id.tvServantRarityCard)
        private val collectionNoTextView: TextView = itemView.findViewById(R.id.tvServantCollectionNoCard)



        fun bind(craftEssence: CraftEssence) {

            nameTextView.text = craftEssence.name
            rarityTextView.text = craftEssence.rarity.toString()
            collectionNoTextView.text = craftEssence.collectionNo.toString()

            craftEssence.face?.let { url ->
                Glide.with(itemView.context)
                    .load(craftEssence.face)
                    .placeholder(R.drawable.ic_download)
                    .error(R.drawable.ic_error)
                    .override(200, 200)
                    .into(imageView)
            }




        }



    }
}