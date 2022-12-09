package com.example.laba1

class Salmon(size:Int):AnimalBase(Type.water, size) {
    override fun move():String {
        return "I am swimming."
    }
    fun migrate() {
        print ("I am migrating.")
    }
}