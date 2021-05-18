package com.example.barom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class InfoActivity1 : AppCompatActivity() {

    lateinit var listView: ExpandableListView

    //변수 선언
    lateinit var homeBtn3: Button
    lateinit var hospitalBtn3: Button
    lateinit var imfoBtn3: Button
    lateinit var quest3: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info2)

        val newDisplay = windowManager.defaultDisplay
        val width = newDisplay.width

        homeBtn3 = findViewById(R.id.homeBtn3)
        hospitalBtn3 = findViewById(R.id.hospitalBtn3)
        imfoBtn3 = findViewById(R.id.imfoBtn3)
        quest3 = findViewById(R.id.quest3)

        homeBtn3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        hospitalBtn3.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        imfoBtn3.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
        quest3.setOnClickListener {
            val intent = Intent(this, QuestView::class.java)
            startActivity(intent)
        }

        val DataList = ArrayList<myGroup>()
        listView = findViewById<View>(R.id.mylist) as ExpandableListView
        var temp = myGroup("HPV 백신이란?")
        temp.child.add("가다실®은 HPV*감염에 의한 자궁경부암, 외음부암, 질암(여성 해당), 항문암 및 생식기 사마귀 등을 예방할 수 있으며, 성별 관계 없이 남녀 모두 접종할 수 있는 HPV 백신입니다. \n가다실®은만 9-26세 남녀 모두 접종 가능한 국내 유일 4가 HPV 백신이며, 10년 이상 장기 임상 연구를 통해 지속적인 예방 효과를 입증하였습니다. ")
        DataList.add(temp)
        temp = myGroup("언제 접종하는 것이 맞는가?")
        temp.child.add("내가 어찌 아오")
        DataList.add(temp)
        temp = myGroup("오늘부터 시작")
        temp.child.add("뭐를?")
        DataList.add(temp)

        val adapter =
            ExpandAdapter(applicationContext, R.layout.group_row, R.layout.child_row, DataList)
        listView.setIndicatorBounds(width - 50, width) //이 코드를 지우면 화살표 위치가 바뀐다.

        listView.setAdapter(adapter)
    }
}