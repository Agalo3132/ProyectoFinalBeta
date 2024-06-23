package com.example.proyectofinal.ui.gamedata.data.fullInfo

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.proyectofinal.R
import com.example.proyectofinal.model.basicInfo.servant.Servant
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ServantFullInfoFragment : Fragment() {

    private lateinit var servant: Servant


    companion object {
        fun newInstance() = ServantFullInfoFragment()
    }

    private val viewModel: ServantFullInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_servant_full_info, container, false)
    }

    //NO SE SI VA PERO NO SE
    /**
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val servantJson = arguments?.getString("selected_servant") ?: return
        servant = Json.decodeFromString(servantJson)

        view.findViewById<TextView>(R.id.tvServantFullInfoName).text = servant.name
        view.findViewById<TextView>(R.id.tvServantFullInfoId).text = servant.id.toString()
        // Establece otras propiedades del sirviente en las vistas respectivas
    }
    **/

}