package com.example.homework.MapObjects

import com.example.homework.Essence.*

class SteveHouse : Beatable, Consumable, Ownable {
    override val army: Army = Army(7)
    override var ownerId: Int? = null
    override val treasure: Treasure = Treasure(7)
}