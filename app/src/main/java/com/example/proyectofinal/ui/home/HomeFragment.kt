package com.example.proyectofinal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentHomeBinding
import java.lang.StringBuilder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        val root: View = binding.root
        //val textView: TextView = binding.textHome



        //DE AQUI
        /**
        homeViewModel.servantsLiveData.observe(viewLifecycleOwner) {
            val text = StringBuilder()

            for (servant in it)
                text.append(servant.name).append("\n")
            //textView.text = text
        }
        **/
        //HASTA AQUI PARA MOVER A OTRO FRAGMENT JUNTO  LO DEL VIEWMODEL



        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}