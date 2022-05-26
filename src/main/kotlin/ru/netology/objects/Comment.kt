package ru.netology.objects

import ru.netology.attachment.Attachment

data class Comment(
    val ownerId: Int = 123,
    val postId: Int,
    val fromGroup: Int = 0,
    val message: String = "",
    val replyToComment: Int = 0,
    val attachments: Attachment? = null,
    val stickerId: Int = 0,
    val guid: String = ""
) {
}