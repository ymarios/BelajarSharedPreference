package com.adl.belajarsharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tugas_shared_preference.*

class TugasSharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas_shared_preference)

        val sharedPreference = getSharedPreferences("setting", Context.MODE_PRIVATE)

        val inputData = sharedPreference.getString("input data","")

        var editor = sharedPreference.edit()

        inptData.setText(inputData)


        btnSave.setOnClickListener({
            if (checkBox.isChecked){
                //var editor = sharedPreference.edit()
                editor.putString("username", txtUsername.text.toString())
                editor.putBoolean("checkbox", true)
                editor.commit()
            }
        })

        btnClear.setOnClickListener({
            editor.clear()
            editor.commit()
        })


    }
}