package com.example.loginwalmart

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data=ArrayList<user>()
    var user1=user("Jhon","Abraham","jhon@gmail.com","abcd")
    var user2=user("Semere","Jhon","semere@gmail.com","abc")
    var user3=user("Haile","Tom","haile@gmail.com","abc")
    var user4=user("Gebre","Tedi","gebre@gmail.com","abc")
    var user5=user("tecle","Dani","tecle@gmail.com","abc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data.add(user1)
        data.add(user2)
        data.add(user3)
        data.add(user4)
        data.add(user5)
        var newIntt=intent
        var new=newIntt.getSerializableExtra("newAccount")
        if(new!=null){
            var newUser=new as user
            data.add(newUser)
            Toast.makeText(this,"Account created successfully.",Toast.LENGTH_LONG).show()
        }

    }
    fun login(view:View){
        var username=txtEmail.text.toString()
        var password=txtPassword.text.toString()
        var flag=false
        for(i in data){
            if (username.equals(i.userName) && password.equals(i.password)){
                var person=user(i.firstName,i.lastName,i.userName,i.password)
                var intent=Intent(this,Shoppping_activity::class.java)
                intent.putExtra("person",person)
                startActivity(intent)
                flag=true
            }
        }
        if (flag==false)
            Toast.makeText(this,"Wrong User Name or Password",Toast.LENGTH_LONG).show()
    }

    fun new_account(view:View){
        var intent=Intent(this,createAccount::class.java)
        startActivity(intent)
    }

    fun forgetPwd(view:View){
        var uName=txtEmail.text.toString()
        var flag=false
        if(uName!=null || uName!=""){
            for(i in data)
                if(i.userName==uName){
                    var intt=Intent()
                    intt.action=Intent.ACTION_SEND
                    intt.type="text/plain"
                    intt.putExtra(Intent.EXTRA_TEXT,i.password)
                    startActivity(intt)
                    flag=true
                }
        }
        if(flag==false)
            Toast.makeText(this,"Please first fill your User Name",Toast.LENGTH_LONG).show()
    }
}
