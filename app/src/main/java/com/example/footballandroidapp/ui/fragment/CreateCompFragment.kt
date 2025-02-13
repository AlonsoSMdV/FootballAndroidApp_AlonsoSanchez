package com.example.footballandroidapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.footballandroidapp.R
import com.example.footballandroidapp.data.remote.comps.CompCreate
import com.example.footballandroidapp.data.remote.comps.CompRawAttributes
import com.example.footballandroidapp.databinding.FragmentCreateCompBinding
import com.example.footballandroidapp.ui.viewModel.CreateCompViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateCompFragment : Fragment(R.layout.fragment_create_comp){
    private lateinit var binding: FragmentCreateCompBinding
    private val viewModel: CreateCompViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateCompBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createCompsToolbar.apply {
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }


        val btnCreate = view.findViewById<Button>(R.id.create_comp)
        btnCreate.setOnClickListener{
            val name = binding.editTextCompName.text.toString()

            if (name.isBlank()) {
                Toast.makeText(requireContext(),"Rellene todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                val createComp = CompCreate(
                    data = CompRawAttributes(
                        name = name
                    )
                )
                viewModel.CreateComp(createComp)
                findNavController().navigate(R.id.create_to_comps)
            }
        }
    }
}