package com.example.proyectofinal.ui.gamedata.data

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal.R
import com.example.proyectofinal.adapter.CommandCodeAdapter
import com.example.proyectofinal.adapter.CraftEssenceAdapter
import com.example.proyectofinal.databinding.FragmentCommandCodeInfoBinding
import com.example.proyectofinal.databinding.FragmentCraftEssenceInfoBinding
import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode
import com.example.proyectofinal.model.basicInfo.craftEssence.CraftEssence

class CraftEssenceInfoFragment : Fragment() {

    private var _binding: FragmentCraftEssenceInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CraftEssenceInfoViewModel by viewModels()
    private lateinit var craftEssenceAdapter: CraftEssenceAdapter
    private lateinit var craftEssenceList: List<CraftEssence>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCraftEssenceInfoBinding.inflate(inflater, container, false)


        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvCraftEssences.layoutManager = LinearLayoutManager(context)
        craftEssenceAdapter = CraftEssenceAdapter(emptyList())
        binding.rvCraftEssences.adapter = craftEssenceAdapter


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()


    }



    private fun observeViewModel() {
        viewModel.craftEssenceLiveData.observe(viewLifecycleOwner, Observer { craftEssences ->
            craftEssenceAdapter.updateCommandCodes(craftEssences)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}