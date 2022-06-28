package com.example.registrationloginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrationandloginscreen.LoginActivity
import com.example.registrationandloginscreen.RegistrationActivity
import com.example.registrationandloginscreen.databinding.ScreenMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ScreenMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ScreenMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            Intent(this, LoginActivity::class.java).also{
                startActivity(it)
            }
        }

        binding.btnCreateNewAccount.setOnClickListener {
            Intent(this, RegistrationActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}
