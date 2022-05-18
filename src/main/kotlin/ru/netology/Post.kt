package ru.netology

import ru.netology.objects.*
import ru.netology.objects.wallservice.*
import java.time.LocalDateTime

data class Post(
    val ownerId: Int = 123,
    val fromId: Int = 123,
    val createdBy: Int? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val text: String = "",
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Like? = null,
    val reposts: Reposts? = null,
    val views: View? = null,
    val postType: PostType = PostType.POST,
    val postSource: PostSource? = null,
    val geo: Geo? = null,
    val signerId: Int? = null,
    val copyHistory: ArrayList<Reposts>? = null,
    val canPin: Boolean = true,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut? = null,
    val postponedId: Int = 0
) {
    var id = 0

}
