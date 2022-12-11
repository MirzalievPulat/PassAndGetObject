package com.example.passandgetobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.passandgetobject.model.Member
import com.example.passandgetobject.model.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initviews()
    }

    fun initviews(){
        val text = findViewById<TextView>(R.id.text)
        val text2 = intent.getParcelableExtra<User>("user")
        text.text = text2.toString()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val member = Member("Click", "Junior")
            backToMainActivity(member)
        }
    }

    fun backToMainActivity(member: Member){
        val intent = Intent()
        intent.putExtra("member", member)
        setResult(RESULT_OK,intent)
        finish()
    }
}