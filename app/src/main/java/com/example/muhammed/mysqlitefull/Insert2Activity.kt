package com.example.muhammed.mysqlitefull

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Insert2Activity : AppCompatActivity() {

    internal var helper = DatabaseHelper(this)
    lateinit var btn :Button
    lateinit var editText:EditText
    lateinit var editText2:EditText
    lateinit var editText3:EditText
    lateinit var editText4:EditText
    lateinit var editText5:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert2)

        editText = findViewById(R.id.firstname)
        editText2 = findViewById(R.id.lastname)
        editText3 = findViewById(R.id.age)
        editText4 = findViewById(R.id.address)
        editText5 = findViewById(R.id.department)

        btn = findViewById(R.id.insert)

        btn.setOnClickListener {
            helper.insertData(editText.text.toString().trim(),
                    editText2.text.toString().trim(),
                    editText3.text.toString().trim(),
                    editText4.text.toString().trim(),
                    editText5.text.toString().trim())
            Toast.makeText(this, "Inserted",Toast.LENGTH_LONG).show()
        }

    }
}
