package com.mastercoding.luckynumber
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for app icon in
        val img : ImageView = findViewById(R.id.imageView)
        img.setImageResource(R.drawable.seven)

        var txt : TextView = findViewById(R.id.textView)
        var edtTxt : EditText = findViewById(R.id.edtTxtName)
        var btn : Button = findViewById(R.id.findBtn)

        btn.setOnClickListener(){

            //getting username from edit text
            var username = edtTxt.text.toString()

            //using explict intents
            var i = Intent(this, LuckyNumberActivity::class.java)

            //passing username
            i.putExtra("name",username)

            startActivity(i)
        }
    }
}