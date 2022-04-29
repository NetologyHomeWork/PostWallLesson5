package ru.netology.objects

data class Place(
    val id: Int,
    val title: String,
    val latitude: Int, // Географическая широта, заданная в градусах (от -90 до 90)
    val longitude: Int, // Географическая широта, заданная в градусах (от -90 до 90)
    val created: Int, // Дата создания места в Unixtime
    val icon: String, // Иконка места, URL изображения
    val checkins: Int = 0, // Число отметок в этом месте
    val updated: Int = 0, // Дата обновления места в Unixtime
    val type: Int = 0, // Тип места
    val country: Int = 25, // Идентификатор страны.
    val city: Int = 35, // Идентификатор города.
    val address: String // Адрес места.
)
