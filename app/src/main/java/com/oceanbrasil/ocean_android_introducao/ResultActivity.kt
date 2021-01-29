package com.oceanbrasil.ocean_android_introducao

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    companion object{
        const val RESULT = "Result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val userName =  intent.getStringExtra(MainActivity.USER_NAME)
        val textView = findViewById<TextView>(R.id.textView)

        textView.text = userName

        val btSendResult = findViewById<Button>(R.id.btSendButton)

        btSendResult.setOnClickListener{
            val intent = Intent()

            intent.putExtra(RESULT,getString(R.string.sendButtonResult))
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

}