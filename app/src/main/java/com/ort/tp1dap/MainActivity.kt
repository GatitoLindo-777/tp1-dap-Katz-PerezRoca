package com.ort.tp1dap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    lateinit var label : TextView
    lateinit var input : EditText
    lateinit var input2 : EditText
    lateinit var btn : Button
    private var inputText : String = ""
    private var inputNum : String = ""
    private var user : String = "gaspar"
    private var password : String = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        label = findViewById (R.id.Text)
        btn = findViewById(R.id.button)
        input = findViewById(R.id.userText)
        input2 = findViewById(R.id.passwordText)

        label.text = ""

        btn.setOnClickListener{
        inputText = input.text.toString()
            inputNum = input2.text.toString()

            if((inputText == user) && (inputNum == password)){
                label.text = "ingresaste"
            }
            else if (inputText.isEmpty()) {
            //label.text = inputText
            Snackbar.make(it,  "ingrese texto", Snackbar.LENGTH_SHORT).show()
            }
            else {
                label.text = "usuario o contraseña incorrecto"
            }
        }




    }
}