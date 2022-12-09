package com.example.laba1

class Hawk(size:Int):AnimalBase(Type.air, size), IHunter {
    override fun move():String {
        return "I am flying."
    }
    override fun hunt():String {
        return "I am hunter."
    }
}