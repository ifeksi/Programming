package com.example.laba1

class Panda(size:Int):AnimalBase(Type.land, size) {
    override fun move():String {
        return "I am running."
    }
    fun beauty() {
        print ("I am so cool.")
    }
}