package ru.netology

import ru.netology.objects.*
import java.time.LocalDateTime

data class Post(
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: LocalDateTime,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Like,
    val reposts: Reposts,
    val views: View,
    val postType: PostType,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int
) {
    private var id = 0

    fun setId(value: Int) {
        id = value
    }

    fun getId(): Int {
        return id
    }
}
