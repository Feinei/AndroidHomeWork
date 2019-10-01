package com.example.homework

import com.example.homework.Essence.Beatable
import com.example.homework.Essence.Consumable
import com.example.homework.Essence.Ownable
import com.example.homework.Essence.Player

class Interaction {
    companion object {
        fun Make(player: Player, mapObject : Any) {
            if (mapObject is Beatable && !player.canBeat(mapObject.army))
                player.die()

            if (mapObject is Ownable && !player.dead && mapObject.ownerId != null)
                mapObject.ownerId = player.id

            if (mapObject is Consumable && !player.dead)
                player.consume(mapObject.treasure)
        }
    }
}