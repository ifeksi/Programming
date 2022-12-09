package com.example.laba1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Recycler(private val context: Context, private val animals: List<AnimalBase>) : RecyclerView.Adapter<Recycler.AnimalRecyclerHolder>() {

    private val onMove: (AnimalBase) -> Unit =
        {
            animal -> val intent = Intent (context, InfoActivity::class.java)
            intent.putExtra("info", animal.move())
            context.startActivity(intent)
        }

    private val onHunt: (IHunter) -> Unit =
        {
            animal -> val intent = Intent (context, InfoActivity::class.java)
            intent.putExtra("info", animal.hunt())
            context.startActivity(intent)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalRecyclerHolder =
        AnimalRecyclerHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.animal_recycler_item, parent, false))

    override fun onBindViewHolder(holder: AnimalRecyclerHolder, position: Int) {

        val animal = animals[position];

        holder.animalTypeHabitat.text = animal.type.toString()
        holder.animalTypeSpecies.text = animal.javaClass.simpleName
        holder.animalSize.text = "size: " + animal.size.toString()
        holder.animalMovement.setOnClickListener { onMove(animal) }

        if(animal is IHunter) {

            holder.animalHunt.setOnClickListener { onHunt(animal) }

        } else {

            holder.animalHunt.visibility = View.GONE

        }

    }

    override fun getItemCount(): Int = animals.size

    class AnimalRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val animalTypeHabitat: TextView = itemView.findViewById(R.id.animal_type_habitat)
        val animalTypeSpecies: TextView = itemView.findViewById(R.id.animal_type_species)
        val animalSize: TextView = itemView.findViewById(R.id.animal_size)

        val animalMovement: Button = itemView.findViewById(R.id.animal_movement)
        val animalHunt: Button = itemView.findViewById(R.id.animal_hunt)

    }

}