package com.example.footballandroidapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.footballandroidapp.ui.viewModel.AuthViewModel
import com.example.footballandroidapp.R
import com.example.footballandroidapp.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {
    private val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registerButton = view.findViewById<Button>(R.id.register_btn)

        val toLogin = view.findViewById<TextView>(R.id.to_login)
        (activity as MainActivity).bottomNav.visibility = View.GONE
        registerButton.setOnClickListener {
            val username = view.findViewById<EditText>(R.id.username).text.toString()
            val email = view.findViewById<EditText>(R.id.email).text.toString()
            val password = view.findViewById<EditText>(R.id.password).text.toString()
            viewModel.register(username, email, password)
        }

        viewModel.registerResult.observe(viewLifecycleOwner) { result ->
            if (result.isSuccess) {
                Toast.makeText(context, "Nuevo usuario registrado", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.register_to_login)
            } else {
                Toast.makeText(context, "Fallo al registrar}", Toast.LENGTH_SHORT).show()
            }
        }

        toLogin.setOnClickListener{
            findNavController().navigate(R.id.register_to_login)
        }
    }
}