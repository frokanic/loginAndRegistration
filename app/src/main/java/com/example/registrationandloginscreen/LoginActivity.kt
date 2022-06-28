package com.example.registrationandloginscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.registrationandloginscreen.databinding.LoginScreenBinding

class LoginActivity : AppCompatActivity()  {

    private lateinit var binding: LoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginCreateNewAccount.setOnClickListener {
            Intent(this, RegistrationActivity::class.java).also{
                startActivity(it)
            }
        }
    }



}