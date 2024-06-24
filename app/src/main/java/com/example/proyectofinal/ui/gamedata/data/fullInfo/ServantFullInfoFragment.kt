package com.example.proyectofinal.ui.gamedata.data.fullInfo

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal.R
import com.example.proyectofinal.adapter.ServantAdapter
import com.example.proyectofinal.adapter.ServantFullInfoAdapter
import com.example.proyectofinal.databinding.FragmentServantFullInfoBinding
import com.example.proyectofinal.databinding.FragmentServantInfoBinding
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.example.proyectofinal.ui.gamedata.data.ServantInfoViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ServantFullInfoFragment : Fragment() {

    private lateinit var servant: Servant

    private var _binding: FragmentServantFullInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ServantFullInfoViewModel by viewModels()
    private lateinit var servantAdapter: ServantFullInfoAdapter
    private lateinit var servantsList: List<Servant>
    private lateinit var servants: Servant



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServantFullInfoBinding.inflate(inflater, container, false)





        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()


    }

    private fun setupRecyclerView() {
        binding.rvFullInfoServants.layoutManager = LinearLayoutManager(context)
        servantAdapter = ServantFullInfoAdapter(emptyList())
        binding.rvFullInfoServants.adapter = servantAdapter


    }


    private fun observeViewModel() {
        viewModel.servantsLiveData.observe(viewLifecycleOwner, Observer { servants ->
            servantAdapter.updateServants(servants)
        })
    }





}