package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homework.Essence.Player
import com.example.homework.MapObjects.SteveHouse
import kotlin.jvm.internal.Intrinsics

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player = Player(1)
        val mapObj = SteveHouse()
        Interaction.Make(player, mapObj)
        val logTag = MainActivity::class.java.simpleName
        Log.e(logTag, "Player gold : ${player.gold}")
    }
}
