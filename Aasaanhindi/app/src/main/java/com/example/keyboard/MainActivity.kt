package com.example.keyboard

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    private lateinit var btn1 : Button;
    private lateinit var btn2 : Button;
    private lateinit var txt1 : TextView;
    private lateinit var txt2 : EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)
        txt1 = findViewById(R.id.textView)
        txt2 = findViewById(R.id.editTextTextPersonName)
        btn2.isVisible = false
        txt1.isVisible = false
        txt2.isVisible = false
        btn1.setOnClickListener {
            btn1.isVisible = false;
            val enableIntent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
            enableIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            this.startActivity(enableIntent)
            btn2.isVisible = true
        }
        btn2.setOnClickListener {
            btn2.isVisible = false
            val inputManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.showInputMethodPicker()
            txt1.isVisible = true
            txt2.isVisible = true }
//        val keyboard = CustomKeyboard(this, R.xml.keyboard)
//        keyboard.registerKeyboardView(findViewById(R.id.keyboardview))
//        keyboard.registerEditText(findViewById(R.id.edit_query), true)
    }
}