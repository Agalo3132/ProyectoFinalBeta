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
import com.example.proyectofinal.databinding.FragmentCommandCodeInfoBinding
import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode


class CommandCodeInfoFragment : Fragment() {

    private var _binding: FragmentCommandCodeInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CommandCodeInfoViewModel by viewModels()
    private lateinit var commandCodeAdapter: CommandCodeAdapter
    private lateinit var commandCodeList: List<CommandCode>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommandCodeInfoBinding.inflate(inflater, container, false)


        return binding.root
    }


    private fun setupRecyclerView() {
        binding.rvCommandCodes.layoutManager = LinearLayoutManager(context)
        commandCodeAdapter = CommandCodeAdapter(emptyList()) //QUITAR EL THIS SI NO VA
        binding.rvCommandCodes.adapter = commandCodeAdapter


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()


    }




    private fun observeViewModel() {
        viewModel.commandCodeLiveData.observe(viewLifecycleOwner, Observer { commandCodes ->
            commandCodeAdapter.updateCommandCodes(commandCodes)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}