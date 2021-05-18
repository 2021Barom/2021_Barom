package com.example.barom

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //변수 선언
    lateinit var homeBtn: Button
    lateinit var hospitalBtn:Button
    lateinit var infoBtn:Button
    lateinit var questBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeBtn = findViewById(R.id.homeBtn)
        hospitalBtn = findViewById(R.id.hospitalBtn)
        infoBtn = findViewById(R.id.infoBtn)
        questBtn = findViewById(R.id.questBtn)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        hospitalBtn.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        infoBtn.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
        questBtn.setOnClickListener {
            val intent = Intent(this, QuestView::class.java)
            startActivity(intent)
        }
    }
}