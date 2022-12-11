package com.example.passandgetobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.passandgetobject.model.Member
import com.example.passandgetobject.model.User

class MainActivity : AppCompatActivity() {
    lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initviews()
    }

    fun initviews(){
        text = findViewById<TextView>(R.id.text)
        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val user = User(11, "Po'lat")
            openSecondActivity(user)
        }
    }

    val resutLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ resut ->
        if (resut.resultCode == RESULT_OK){
            val data = resut.data
            val member = data!!.getParcelableExtra<Member>("member")
            text.text = member.toString()
        }
    }

    fun openSecondActivity(user:User){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        resutLauncher.launch(intent)
    }
}