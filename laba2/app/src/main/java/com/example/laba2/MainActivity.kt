package com.example.laba2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.motion.TransitionBuilder.validate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_plus.setOnClickListener {
            valid(edt_one.text.toString(), edt_two.text.toString(), '+')
        }

        btn_minus.setOnClickListener {
            valid(edt_one.text.toString(), edt_two.text.toString(), '-')
        }

        btn_multiple.setOnClickListener {
            valid(edt_one.text.toString(), edt_two.text.toString(), '*')
        }

        btn_share.setOnClickListener {
            valid(edt_one.text.toString(), edt_two.text.toString(), '/')
        }

        }
        private fun valid(awal:String, kedua:String, operator:Char) {
            if (awal.isEmpty()) {
                edt_one.error = "Введіть цифру!"
            }
            if (kedua.isEmpty()) {
                edt_two.error = "Введіть цифру!"
            }
            if (awal.isNotEmpty() && kedua.isNotEmpty()) {
                calculation(awal.toDouble(), kedua.toDouble(), operator)
            }
        }

        private fun calculation(awal:Double, kedua:Double, operator:Char) {
            var result = 0.0
            when(operator) {
                '+' -> result = awal + kedua
                '-' -> result = awal - kedua
                '*' -> result = awal * kedua
                '/' -> result = awal / kedua
            }
            tv_result.text = result.toString()
        }
    }
