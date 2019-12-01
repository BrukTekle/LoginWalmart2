package com.example.loginwalmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*

class createAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    fun createAccount(view: View) {
        var fName=txtFirstName.text.toString()
        var lName=txtLastName.text.toString()
        var emaila=txtEmail.text.toString()
        var pass=txtPassword.text.toString()
        var flag=false
        if(fName!="" && lName!="" && emaila!="" && pass!=""){
            var newAccount=user(fName,lName,emaila,pass)
            var intt=Intent(this,MainActivity::class.java)
            intt.putExtra("newAccount",newAccount)
            startActivity(intt)
            flag=true
        }
        if (flag==false)
            Toast.makeText(this,"Please first fill all the fields",Toast.LENGTH_LONG).show()
    }
}
