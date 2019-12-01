package com.example.loginwalmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shoppping_activity.*

class Shoppping_activity : AppCompatActivity() {
    lateinit var result: user
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoppping_activity)
        imageView.setOnClickListener {
            Toast.makeText(this,"You have chosen the Clothing category of shopping",Toast.LENGTH_LONG).show()
        }
        imageView2.setOnClickListener {
            Toast.makeText(this,"You have chosen the Electronic category of shopping",Toast.LENGTH_LONG).show()
        }
        imageView3.setOnClickListener {
            Toast.makeText(this,"You have chosen the Beauty category of shopping",Toast.LENGTH_LONG).show()
        }
        imageView4.setOnClickListener {
            Toast.makeText(this,"You have chosen the Food category of shopping",Toast.LENGTH_LONG).show()
        }
        var intt=intent
        var person=intt.getSerializableExtra("person")
        result=person as user
        txtUser.text="Welcome "+result.userName
    }
}
