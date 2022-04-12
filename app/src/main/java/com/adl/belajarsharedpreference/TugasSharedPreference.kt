package com.adl.belajarsharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tugas_shared_preference.*

class TugasSharedPreference : AppCompatActivity() {

    var sliderValue: Int = 0
    var groupCombo:Int = 0
    var switchComp:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas_shared_preference)

        val sharedPreference = getSharedPreferences("setting", Context.MODE_PRIVATE)

        val inputData = sharedPreference.getString("input data","")

        val radio = sharedPreference.getString("radio","")

        var editor = sharedPreference.edit()

        setContentView(R.layout.activity_tugas_shared_preference)

        inptData.setText(inputData)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seek.setText("Nilainya adalah : ${p1.toString()}")
                sliderValue = p1

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1:Int) {

                val resultt = when(p1){
                    R.id.rdbtnOpt1 -> "Option 1"
                    R.id.rdbtnOpt2 -> "Option 2"
                    R.id.rdbtnOpt3 -> "Option 3"
                    else -> "No Option"
                }
                Toast.makeText(this@TugasSharedPreference, "Pilihannya adalah ${resultt}", Toast.LENGTH_LONG).show()
                groupCombo = p1
            }
        })

        switch1.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked) switch1.text="ON" else switch1.text="OFF"
            switchComp = isChecked
        })

        btnSave.setOnClickListener({
            if (checkBox.isChecked){
                editor.putInt("slider", sliderValue)
                editor.putInt("combo", groupCombo)
                editor.putBoolean("switch", switchComp)

            }
        })


        btnClear.setOnClickListener({
            editor.clear()
            editor.commit()
        })


    }
}