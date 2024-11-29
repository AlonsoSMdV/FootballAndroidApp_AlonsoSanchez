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
class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton = view.findViewById<Button>(R.id.login_btn)
        val toRegister = view.findViewById<TextView>(R.id.to_register)
        (activity as MainActivity).bottomNav.visibility = View.GONE
        loginButton.setOnClickListener {
            val username = view.findViewById<EditText>(R.id.username).text.toString()
            val password = view.findViewById<EditText>(R.id.password).text.toString()
            viewModel.login(username, password)
        }

        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            if (result.isSuccess) {
                Toast.makeText(context, "Bienvenido, ${view.findViewById<EditText>(R.id.username).text}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.login_to_comps)
            } else {
                Toast.makeText(context, "Login failed: ${result.exceptionOrNull()?.message}", Toast.LENGTH_SHORT).show()
            }
        }

        toRegister.setOnClickListener{
            findNavController().navigate(R.id.login_to_register)
        }
    }
}