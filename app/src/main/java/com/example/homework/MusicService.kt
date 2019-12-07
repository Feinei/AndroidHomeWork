package com.example.homework

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MusicService : Service() {

    companion object {
        val DEFAULT_SONG = SongsRepository.dataSource.first()
        const val DEFAULT_REQUEST_CODE = 0
        const val DEFAULT_FLAG = 0
        const val DEFAULT_NOTIF_ID = 1
        const val DEFAULT_CHANNEL_ID = "1"
        const val TITLE_PREV = "Previous"
        const val TITLE_NEXT = "Next"
        const val TITLE_PLAY = "Play/Pause"
    }

    private var player: MediaPlayer? = null
    private var currentSong: Song = DEFAULT_SONG
    private var isPlaying = false

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, currentSong.audioId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return Binder()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        when (intent.action) {
            Actions.INIT -> setSongOnPlayer(getSongFromBundle(intent.getBundleExtra(ExtraKeys.SONG_OBJECT)))
            Actions.PREV -> setSongOnPlayer(SongsRepository.getPrevSongId(currentSong.audioId))
            Actions.NEXT -> setSongOnPlayer(SongsRepository.getNextSongId(currentSong.audioId))
            Actions.START_PAUSE -> startPausePlayer()
            Actions.STOP -> stopPlayer()
            Actions.UPDATE_NOTIF -> updateNotification(getSongFromBundle(intent.getBundleExtra(ExtraKeys.SONG_OBJECT)))
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun setSongOnPlayer(song: Song) {
        player?.pause()
        player = MediaPlayer.create(this, song.audioId)
        currentSong = song
        player?.start()
        isPlaying = true
        updateNotification(song)
    }

    private fun startPausePlayer() {
        isPlaying = if (isPlaying) {
            player?.pause()
            false
        } else {
            player?.start()
            true
        }
    }

    private fun stopPlayer() {
        player?.pause()
        player = null
    }

    private fun getSongFromBundle(bundle: Bundle): Song = Song(
        bundle.getString(ExtraKeys.SONG_NAME),
        bundle.getString(ExtraKeys.ARTIST),
        bundle.getString(ExtraKeys.ALBUM),
        bundle.getInt(ExtraKeys.COVER_ID),
        bundle.getInt(ExtraKeys.SONG_ID)
    )

    private fun updateNotification(song: Song) {

        val getIntent = { action: String -> Intent(this, MusicService::class.java).setAction(action) }
        val getPendingIntent =
            { action: String -> PendingIntent.getService(this, DEFAULT_REQUEST_CODE, getIntent(action), DEFAULT_FLAG) }

        val notification = NotificationCompat.Builder(this, DEFAULT_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(song.name)
            .setContentText(song.artist)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.cover))
            .addAction(R.drawable.cover, TITLE_PREV, getPendingIntent(Actions.PREV))
            .addAction(R.drawable.cover, TITLE_PLAY, getPendingIntent(Actions.START_PAUSE))
            .addAction(R.drawable.cover, TITLE_NEXT, getPendingIntent(Actions.NEXT))
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(DEFAULT_NOTIF_ID, notification)
    }
}
