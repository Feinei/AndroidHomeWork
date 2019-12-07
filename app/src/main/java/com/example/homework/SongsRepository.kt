package com.example.homework

class SongsRepository {

    companion object {

        val dataSource: List<Song> = listOf(
            Song("Дни и ночи", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_dni_nochi),
            Song("Главное, чтобы костюмчик сидел", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_kostumchik),
            Song("Кто ты такой, чтобы ради тебя", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_kto_ti),
            Song("Лучший возраст", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_luchshi_vozrast),
            Song("Старые солдаты", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_soldati),
            Song("Ты танцуешь под слова", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_tancuesh),
            Song("Ю-зе-фа", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_usefa),
            Song("Застыл и остыл", "Ада", "Песни облака", R.drawable.cover, R.raw.ada_zastil_ostil)
        )

        fun getPrevSongId(songId: Int): Song {
            var prevSong = dataSource.last()
            for (song in dataSource) {
                if (songId == song.audioId) return prevSong
                prevSong = song
            }
            return dataSource.last()
        }

        fun getNextSongId(songId: Int): Song {
            var found = false
            for (song in dataSource.take(dataSource.count() - 1)) {
                if (found)
                    return song
                if (songId == song.audioId)
                    found = true
            }
            return dataSource.first()
        }
    }
}
