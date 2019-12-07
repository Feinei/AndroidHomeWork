package com.example.homework

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var bound = false
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, binder: IBinder) {
            bound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            bound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindMusicService()
        initSongAdapter()
        setClickListeners()
    }

    private fun bindMusicService() {
        bindService(
            Intent(this, MusicService::class.java),
            serviceConnection,
            Context.BIND_AUTO_CREATE
        )
    }

    private fun initSongAdapter() {
        val adapter = SongAdapter {

            val bundle = Bundle().apply {
                putInt(ExtraKeys.COVER_ID, it.coverId)
                putInt(ExtraKeys.SONG_ID, it.audioId)
                putString(ExtraKeys.SONG_NAME, it.name)
                putString(ExtraKeys.ALBUM, it.album)
                putString(ExtraKeys.ARTIST, it.artist)
            }

            startService(Intent(this, MusicService::class.java).apply {
                action = Actions.INIT
                putExtra(ExtraKeys.SONG_OBJECT, bundle)
            })

            startActivity(Intent(this, SongActivity::class.java).putExtra(ExtraKeys.SONG_OBJECT, bundle))
        }

        adapter.submitList(SongsRepository.dataSource)
        rv_songs.adapter = adapter
    }

    private fun setClickListeners() {
        btn_stop.setOnClickListener {
            startService(Intent(this, MusicService::class.java).apply {
                action = Actions.STOP
            })
        }
    }
}
