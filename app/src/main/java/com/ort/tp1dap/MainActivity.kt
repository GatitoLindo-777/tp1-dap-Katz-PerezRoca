package com.ort.tp1dap

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
class mutablelist
data class User (var username: String, var password: String)
class MainActivity : AppCompatActivity() {

    lateinit var label: TextView
    lateinit var input: EditText
    lateinit var input2: EditText
    lateinit var btnLogIn: Button
    lateinit var btnSignUp :Button
    private var inputUser: String = ""
    private var inputPass: String = ""
    private var user0: String = "gaspar0"
    private var user1: String = "gaspar1"
    private var user2: String = "gaspar2"
    private var user3: String = "gaspar3"
    private var user4: String = "gaspar4"
    private var password0: String = "0"
    private var password1: String = "1"
    private var password2: String = "2"
    private var password3: String = "3"
    private var password4: String = "4"
    var userData: MutableList<User> = mutableListOf()



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userData.add(User(user0, password0))
        userData.add(User(user1, password1))
        userData.add(User(user2, password2))
        userData.add(User(user3, password3))
        userData.add(User(user4, password4))

        label = findViewById(R.id.Text)
        btnLogIn = findViewById(R.id.button)
        btnSignUp = findViewById(R.id.btn2)
        input = findViewById(R.id.userText)
        input2 = findViewById(R.id.passwordText)

        label.text = ""

        btnLogIn.setOnClickListener {

            val inputUser: String = input.text.toString()
            val inputPass: String = input2.text.toString()

            var userEncontrado: User? = userData.find { u -> u.username == inputUser }

            if (userEncontrado != null && userEncontrado.password == inputPass) {

                label.text = "ingresaste"
            }
            else if (inputUser.isEmpty() || inputPass.isEmpty()) {
                //label.text = inputText
                Snackbar.make(it, "ingrese texto", Snackbar.LENGTH_SHORT).show()
            }
            else {
                label.text = "usuario o contraseña incorrecto"
            }
        }

        btnSignUp.setOnClickListener {
            val inputUser: String = input.text.toString()
            val inputPass: String = input2.text.toString()
            var userEncontrado: User? = userData.find { u -> u.username == inputUser }
            var passEncontrada: User? = userData.find {u -> u.password == inputPass}

            if (!inputUser.isEmpty() && !inputPass.isEmpty()) {
                if (userEncontrado == null && passEncontrada == null) {
                    userData.add(User(inputUser, inputPass))
                    label.text = "ususario creado"
                } 
                else if (userEncontrado != null || passEncontrada != null) {
                    label.text = "usuario o contraseña ya existente"
                }
            }else if (inputUser.isEmpty() || inputPass.isEmpty()) {
                //label.text = inputText
                Snackbar.make(it, "ingrese texto", Snackbar.LENGTH_SHORT).show()
            }

        }

    }
}





//private fun user(user0: String, password0: String): User {











