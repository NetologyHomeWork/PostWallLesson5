package ru.netology.objects.wallservice

data class PostSource(
    val type: TypePostSource,
    val platform: Platform?,
    val data: DataPostSource?,
    val url: String
)
