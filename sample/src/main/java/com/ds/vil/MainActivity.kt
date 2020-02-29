package com.ds.vil

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ds.lib.ValidatorInputLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputConfirmPasswordLayout.addValidator(
            ValidatorInputLayout.Validator("Password not match") {
                inputPassword.text?.toString() == inputConfirmPassword.text?.toString()
            }
        )

        buttonRegister.setOnClickListener {
            val isAllValid = inputNameLayout.isValid &&
                    inputEmailLayout.isValid &&
                    inputPasswordLayout.isValid &&
                    inputConfirmPasswordLayout.isValid
            Toast.makeText(this, "valid: $isAllValid", Toast.LENGTH_SHORT).show()
        }
    }
}