package com.example.laba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val animals: MutableList<AnimalBase> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animalRecycler: RecyclerView = findViewById(R.id.animal_recycler)

        animalRecycler.layoutManager = LinearLayoutManager(this)
        animalRecycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        for (i in 0..20) {

            when(Random.nextInt(0, 3)) {

                0 -> animals.add(Panda(Random.nextInt(30, 40)))
                1 -> animals.add(Hawk(Random.nextInt(10, 15)))
                2 -> animals.add(Salmon(Random.nextInt(3, 5)))

            }

        }

        animalRecycler.adapter = Recycler(this, animals)

    }
}