package com.example.barom


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//목록 보기
class QuestView: AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var btn_add:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quest_listview)

        var questList= arrayListOf<QuestClass>(
            QuestClass("제목입니다",
                "요약입니다",
                "자세한 내용입니다"),
            QuestClass("제목2 입니다",
                "요약2 입니다",
                "자세한 내용2 입니다")
        )


        listView=findViewById(R.id.listview)
        btn_add=findViewById(R.id.btn_add)

        var questlist=questList
        listView.adapter=ListViewAdapter(this, questlist)
        ListViewAdapter(this,questlist).notifyDataSetChanged()
        Toast.makeText(this, ListViewAdapter(this,questlist).getTitle(questlist.size-1),Toast.LENGTH_LONG).show()

        //상세내용 확인->QuestItem으로 넘어감
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"자세한 내용 확인", Toast.LENGTH_SHORT).show()
            val intent=Intent(this, QuestItem::class.java)
            intent.putExtra("title", ListViewAdapter(this,questlist).getTitle(position))
            intent.putExtra("content", ListViewAdapter(this,questlist).getContent(position))
            intent.putExtra("detail", ListViewAdapter(this,questlist).getDetail(position))
            startActivity(intent)
        }

        //질문추가 기능->QuestAdd로 넘어감
        btn_add.setOnClickListener {
            Toast.makeText(this,"질문 추가하기", Toast.LENGTH_SHORT).show()
            val intent=Intent(this, QuestAdd::class.java)
            startActivity(intent)
        }

        //QuestAdd에서 넘어온 데이터를 questlist 배열에 추가
        if(intent.hasExtra("title")) {
            questlist.add(
                QuestClass(intent.getStringExtra("title").toString(),
                    intent.getStringExtra("content").toString(),
                    intent.getStringExtra("detail").toString()
                )
            )
            ListViewAdapter(this, questlist).notifyDataSetChanged()
        }

    }
}