package com.example.proyectofinal.ui.gamedata

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentGamedataBinding

class GamedataFragment : Fragment() {

    private var _binding: FragmentGamedataBinding? = null
    private val binding get() = _binding!!
    lateinit var gamedataViewModel: GamedataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gamedataViewModel = ViewModelProvider(this).get(GamedataViewModel::class.java)
        _binding = FragmentGamedataBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivServant.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_gameData_to_servantInfoFragment)
        }


        binding.ivCommandCode.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_gameData_to_commandCodeInfoFragment)
        }

        binding.ivCraftEssence.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_gameData_to_craftEssenceInfoFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}