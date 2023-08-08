package com.mastercoding.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        //for image
        var img : ImageView = findViewById(R.id.imageView2)
        img.setImageResource(R.drawable.firework)

        var txt = findViewById<TextView>(R.id.luckyNumTxt)
        var luckyNum = findViewById<TextView>(R.id.luckyNum)
        var shareBtn = findViewById<Button>(R.id.shareBtn)

        var user_name = recieveUserName()


        var random_num = generateRandomNum()

        luckyNum.setText(""+random_num)

        shareBtn.setOnClickListener(){
            shareData(user_name,random_num)
        }

    }

    fun recieveUserName():String{
        var bundle : Bundle? = intent.extras
        val username = bundle?.getString("name").toString()
        return username
    }

    fun generateRandomNum(): Int{
        val random = Random().nextInt(1000)
        return random
    }

    fun shareData(username: String, luckyNum: Int){

        //implict intent
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,"$username is lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is $luckyNum")
        startActivity(i)
    }
}