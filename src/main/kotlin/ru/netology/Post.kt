package ru.netology

import ru.netology.objects.*
import java.time.LocalDateTime

data class Post(
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?,
    val date: LocalDateTime,
    val text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val copyright: Copyright?,
    val likes: Like,
    val reposts: Reposts?,
    val views: View,
    val postType: PostType = PostType.POST,
    val postSource: PostSource?,
    val geo: Geo,
    val signerId: Int?,
    val copyHistory: ArrayList<Reposts>?,
    val canPin: Boolean = true,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut?,
    val postponedId: Int = 0
) {
    private var id = 0

    fun setId(value: Int) {
        id = value
    }

    fun getId(): Int {
        return id
    }
}
