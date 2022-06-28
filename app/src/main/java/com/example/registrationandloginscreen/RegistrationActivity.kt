package com.example.registrationandloginscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registrationandloginscreen.databinding.RegistrationScreenBinding
import com.example.registrationandloginscreen.db.User
import com.example.registrationandloginscreen.db.UserViewModel

class RegistrationActivity : AppCompatActivity()  {

    private lateinit var binding: RegistrationScreenBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val dao = UsersDatabase.getInstance(this).UsersDao()

        binding.btnRegRegister.setOnClickListener {
            var lowCaseLetter = false
            var uppCaseLetter = false
            var number = false

            loop@ for (l in binding.etRegPassword.text) {
                if (l in "qwertyuiopasdfghjklzxcvbnm") lowCaseLetter = true
                if (l in "QWRTYUIOPASDFGHJKLZXCVBNM") uppCaseLetter = true
                if (l in "0123456789") number = true

                if (lowCaseLetter && uppCaseLetter && number == true) break@loop
            }

            fun clearPasswordFields() {
                binding.etRegPassword.text.clear()
                binding.etRegConfirmPassword.text.clear()
            }

            fun clearAllFields() {
                binding.etRegPassword.text.clear()
                binding.etRegEmail.text.clear()
                binding.etRegConfirmPassword.text.clear()
                binding.etRegUsername.text.clear()
                binding.etRegFirstName.text.clear()
                binding.etRegLastName.text.clear()
            }

            val properPassword = lowCaseLetter && uppCaseLetter && number
            val emptyFields = (binding.etRegPassword.text.toString() == "" ||
                    binding.etRegEmail.text.toString() == "" ||
                    binding.etRegConfirmPassword.text.toString() == "" ||
                    binding.etRegUsername.text.toString() == "" ||
                    binding.etRegFirstName.text.toString() == "" ||
                    binding.etRegLastName.text.toString() == "")


            if (emptyFields) {
                Toast.makeText(this, "Al fields should be filled", Toast.LENGTH_LONG).show()
            } else if (!properPassword) {
                Toast.makeText(this, "Password should contain at least 1 number, 1 uppercase and one lowercase character", Toast.LENGTH_LONG).show()
                clearPasswordFields()
            } else if (binding.etRegPassword.text.toString().trim() != binding.etRegConfirmPassword.text.toString().trim()) {
                Toast.makeText(this, "The two password fields should match", Toast.LENGTH_LONG).show()
                clearPasswordFields()
            } else {
                val user = User(0, binding.etRegFirstName.text.toString(),
                    binding.etRegLastName.text.toString(),
                    binding.etRegUsername.text.toString(),
                    binding.etRegEmail.text.toString(),
                    binding.etRegPassword.text.toString())
                mUserViewModel.addUser(user)
                clearAllFields()
                Intent(this, LoginActivity::class.java).also{
                    startActivity(it)
                }
            }
        }
    }
}

