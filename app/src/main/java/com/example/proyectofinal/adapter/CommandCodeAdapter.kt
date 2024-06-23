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

class CommandCodeAdapter (private var commandCodes: List<CommandCode>) : RecyclerView.Adapter<CommandCodeAdapter.CommandCodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandCodeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_servant, parent, false)
        return CommandCodeViewHolder(view)
    }

    override fun getItemCount(): Int = commandCodes.size

    fun updateCommandCodes(newCommandCodes: List<CommandCode>) {
        commandCodes = newCommandCodes
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CommandCodeViewHolder, position: Int) {
        val commandCode = commandCodes[position]
        holder.bind(commandCode)
    }


    inner class CommandCodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.ivServantImage)
        private val nameTextView: TextView = itemView.findViewById(R.id.tvServantNombreCard)
        private val rarityTextView: TextView = itemView.findViewById(R.id.tvServantRarityCard)
        private val collectionNoTextView: TextView = itemView.findViewById(R.id.tvServantCollectionNoCard)



        fun bind(commandCode: CommandCode) {

            nameTextView.text = commandCode.name
            rarityTextView.text = commandCode.rarity.toString()
            collectionNoTextView.text = commandCode.collectionNo.toString()

            commandCode.face?.let { url ->
                Glide.with(itemView.context)
                    .load(commandCode.face)
                    .placeholder(R.drawable.ic_download)
                    .error(R.drawable.ic_error)
                    .override(200, 200)
                    .into(imageView)
            }

            Log.d("CommandCodeAdapter", "Loading image: ${commandCode.face}")



        }



    }
}