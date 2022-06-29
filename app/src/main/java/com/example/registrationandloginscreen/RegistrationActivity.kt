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

        binding.btnRegRegister.setOnClickListener {

            var RegFirstName = binding.etRegFirstName.text
            var RegLastName = binding.etRegLastName.text
            var RegUsername = binding.etRegUsername.text
            var RegEmail = binding.etRegEmail.text
            var RegPassword = binding.etRegPassword.text
            var RegConfirmPassword = binding.etRegConfirmPassword.text

            //Checks if the password has at least 1 number, 1 uppercase & 1 lowercase letter
            var lowCaseLetter = false
            var uppCaseLetter = false
            var number = false

            loop@ for (l in binding.etRegPassword.text) {
                if (l in "qwertyuiopasdfghjklzxcvbnm") lowCaseLetter = true
                if (l in "QWRTYUIOPASDFGHJKLZXCVBNM") uppCaseLetter = true
                if (l in "0123456789") number = true

                if (lowCaseLetter && uppCaseLetter && number == true) break@loop
            }


            //Used to clear password fields if the password on the two fields did not match, or if if did not contain all the required characters
            fun clearPasswordFields() {
                RegPassword.clear()
                RegConfirmPassword.clear()
            }

            //Used to clear all fields if registration was successful
            fun clearAllFields() {
                RegPassword.clear()
                RegEmail.clear()
                RegConfirmPassword.clear()
                RegUsername.clear()
                RegFirstName.clear()
                RegLastName.clear()
            }


            val properPassword = lowCaseLetter && uppCaseLetter && number
            val emptyFields = (RegPassword.toString() == "" ||
                    RegEmail.toString() == "" ||
                    RegConfirmPassword.toString() == "" ||
                    RegUsername.toString() == "" ||
                    RegFirstName.toString() == "" ||
                    RegLastName.toString() == "")


            if (emptyFields) {
                Toast.makeText(this, "Al fields should be filled", Toast.LENGTH_LONG).show()
            } else if (!properPassword) {
                Toast.makeText(this, "Password should contain at least 1 number, 1 uppercase and one lowercase character", Toast.LENGTH_LONG).show()
                clearPasswordFields()
            } else if (RegPassword.toString().trim() != RegConfirmPassword.toString().trim()) {
                Toast.makeText(this, "The two password fields should match", Toast.LENGTH_LONG).show()
                clearPasswordFields()
            } else {

                val user = User(0, RegFirstName.toString(),
                    RegLastName.toString(),
                    RegUsername.toString(),
                    RegEmail.toString(),
                    RegPassword.toString())
                mUserViewModel.addUser(user)
                clearAllFields()
                Intent(this, LoginActivity::class.java).also{
                    startActivity(it)
                }
            }
        }
    }
}

