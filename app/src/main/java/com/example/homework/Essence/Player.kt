package com.example.homework.Essence

import com.example.homework.Essence.Army
import com.example.homework.Essence.Treasure

class Player(var id : Int) {
    var gold = 0
    private set

    var dead = false
    private set

    fun canBeat(army: Army) = army.power < 10

    fun consume(treasure: Treasure) {
        gold += treasure.amout
    }

    fun die() {
        dead = true
    }
}