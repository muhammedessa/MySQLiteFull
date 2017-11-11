package com.example.muhammed.mysqlitefull

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class Database2Activity : AppCompatActivity() {

    lateinit var listview : ListView
    internal var helper = DatabaseHelper(this)
    var list = mutableListOf<Employee>()
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database2)

        listview = findViewById(R.id.listview1)
        btn = findViewById(R.id.refresh)

        viewAll()

        val adapter = MyListAdapter(this,R.layout.employee,list)
        listview.adapter = adapter

        btn.setOnClickListener {
            viewAll()
            adapter.notifyDataSetChanged()
        }
    }



    private  fun viewAll(){
        list.clear()
        val res = helper.allData
        if (res.count ==0){
            Toast.makeText(this,"No records :(",Toast.LENGTH_LONG).show()
        }
        while (res.moveToNext()){
            list.add(Employee(  res.getString(0),
                                res.getString(1),
                                res.getString(2),
                                res.getString(3),
                                res.getString(4),
                                res.getString(5)
            )
            )
        }
    }







}
