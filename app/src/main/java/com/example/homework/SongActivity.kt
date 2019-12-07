package com.example.homework

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_song.*

class SongActivity : AppCompatActivity() {

    private lateinit var currentSong: Song

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)

        intent.getBundleExtra(ExtraKeys.SONG_OBJECT)?.let {
            currentSong = Song(
                it.getString(ExtraKeys.SONG_NAME),
                it.getString(ExtraKeys.ARTIST),
                it.getString(ExtraKeys.ALBUM),
                it.getInt(ExtraKeys.COVER_ID),
                it.getInt(ExtraKeys.SONG_ID)
            )
        }

        updateView(currentSong)
        setOnClickListeners()
    }

    private fun updateView(song: Song) {
        tv_album_name.text = song.album
        tv_song.text = song.name
        tv_artist.text = song.artist
        iv_cover.setImageResource(song.coverId)
    }

    private fun setOnClickListeners() {
        btn_start_pause.setOnClickListener {
            startService(Intent(this, MusicService::class.java).apply {
                action = Actions.START_PAUSE
            })
        }

        btn_prev.setOnClickListener {
            startService(Intent(this, MusicService::class.java).apply {
                action = Actions.PREV
            })
            val prevSong = SongsRepository.getPrevSongId(currentSong.audioId)
            updateView(prevSong)
            currentSong = prevSong
        }

        btn_next.setOnClickListener {
            startService(Intent(this, MusicService::class.java).apply {
                action = Actions.NEXT
            })
            val nextSong = SongsRepository.getNextSongId(currentSong.audioId)
            updateView(nextSong)
            currentSong = nextSong
        }
    }
}
