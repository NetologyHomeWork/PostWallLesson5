package ru.netology.objects

data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int = 100_000_000,
    val placeholder: Placeholder?,
    val canPublishFreeCopy: Boolean = false
)
