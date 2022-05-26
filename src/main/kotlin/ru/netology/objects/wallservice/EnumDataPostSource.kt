package ru.netology.objects.wallservice

enum class EnumDataPostSource {
    ProfileActivity, // изменение статуса под именем пользователя (для type = vk)
    ProfilePhoto, // изменение профильной фотографии пользователя (для type = vk)
    Comments, // виджет комментариев (для type = widget)
    Like, // виджет «Мне нравится» (для type = widget)
    Poll // виджет опросов (для type = widget)
}