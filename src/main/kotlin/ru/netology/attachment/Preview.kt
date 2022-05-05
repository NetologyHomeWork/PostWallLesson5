package ru.netology.attachment

class Preview(sizes: Array<Photo>, graffiti: Graffiti, audioMessage: AudioMessage) {

    data class Photo(
        val url: String,
        val width: Int,
        val height: Int,
        val type: String
    )

    data class Graffiti(
        val src: String,
        val width: Int,
        val height: Int
    )

    data class AudioMessage(
        val duration: Int,
        val waveform: ArrayList<Int>,
        val linkOgg: String,
        val linkMp3: String
    )
}

