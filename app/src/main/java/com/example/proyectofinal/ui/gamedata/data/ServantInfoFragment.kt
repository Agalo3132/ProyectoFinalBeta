package com.example.proyectofinal.ui.gamedata.data

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.adapter.ServantAdapter
import com.example.proyectofinal.databinding.FragmentHomeBinding
import com.example.proyectofinal.databinding.FragmentServantInfoBinding
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.example.proyectofinal.network.FateService
import com.example.proyectofinal.network.NetworkService
import com.example.proyectofinal.repository.Repository
import com.example.proyectofinal.ui.gamedata.GamedataViewModel
import com.example.proyectofinal.ui.gamedata.data.fullInfo.ServantFullInfoFragment
import com.example.proyectofinal.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.lang.StringBuilder

//QUITAR SI NO VA EL CLICKLISTENER
class ServantInfoFragment : Fragment() {

    private var _binding: FragmentServantInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ServantInfoViewModel by viewModels()
    private lateinit var servantAdapter: ServantAdapter
    private lateinit var servantsList: List<Servant>

    //QUITAR ESTO SI NO VA
    //private lateinit var servants: List<Servant>


    /**
    companion object {
        fun newInstance() = ServantInfoFragment()
    }
    **/



    /**
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    **/




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //servantInfoViewModel = ViewModelProvider(this).get(ServantInfoViewModel::class.java)
        _binding = FragmentServantInfoBinding.inflate(inflater, container, false)




        //servantAdapter = ServantAdapter(servants, this)
        //recyclerView.adapter = servantAdapter



        return binding.root

    }





    /**
    override fun onItemClick(servant: Servant) {
        val bundle = Bundle().apply {
            putParcelable("servant", servant)
        }
        val fragment = ServantFullInfoFragment().apply {
            arguments = bundle
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }
    **/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()

        /**
        binding.rvServants.setOnClickListener {
            findNavController().navigate(R.id.action_servantInfoFragment_to_servantFullInfoFragment)
        }
        **/

    }





    //VOVLER A ESTE SI NO VA

    private fun setupRecyclerView() {
        binding.rvServants.layoutManager = LinearLayoutManager(context)
        servantAdapter = ServantAdapter(emptyList()) //QUITAR EL THIS SI NO VA
        binding.rvServants.adapter = servantAdapter


    }


    private fun observeViewModel() {
        viewModel.servantsLiveData.observe(viewLifecycleOwner, Observer { servants ->
            servantAdapter.updateServants(servants)
            //servantAdapter = ServantAdapter(servants)
            //binding.rvServants.adapter = servantAdapter
            //servantAdapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}