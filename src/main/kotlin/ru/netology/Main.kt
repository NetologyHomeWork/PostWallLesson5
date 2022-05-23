package ru.netology

fun main() {
    println(WallService.posts.size)
    val post = Post()
    WallService.posts.add(post)
    println(WallService.posts.size)
    WallService.posts.removeLast()
    println(WallService.posts.size)
}