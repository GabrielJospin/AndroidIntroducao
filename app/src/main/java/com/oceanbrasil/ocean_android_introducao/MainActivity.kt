package com.oceanbrasil.ocean_android_introducao

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object{
        const val USER_NAME = "UserName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResultado)
        val etName = findViewById<EditText>(R.id.etNome)
        val btSend = findViewById<Button>(R.id.btEnviar)
        val btOpenResultActivity = findViewById<Button>(R.id.btAbrirResultado)
        val btReceberResultado = findViewById<Button>(R.id.btReceberResultado)

        btSend.setOnClickListener {
            if(etName.text.isNotBlank())
                tvResult.text = getString(R.string.helloMainActivity, etName.text.toString())
            else
                etName.error = getString(R.string.errorMainActivity)
        }

        btOpenResultActivity.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(USER_NAME,etName.text.toString())
            startActivity(intent)
        }

        btReceberResultado.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val requestCode = 1
            intent.putExtra(USER_NAME,etName.text.toString())
            startActivityForResult(intent, requestCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == Activity.RESULT_OK && data != null){
            val result = data.getStringExtra(ResultActivity.RESULT)
            val tvResult = findViewById<TextView>(R.id.tvResultado)
            tvResult.text= getString(R.string.ResultText,result)
        }

    }
}