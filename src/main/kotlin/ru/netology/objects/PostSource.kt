package ru.netology.objects

data class PostSource(
    val type: TypePostSource,
    val platform: Platform?,
    val data: DataPostSource?,
    val url: String
)
