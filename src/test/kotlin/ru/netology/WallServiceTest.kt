package ru.netology

import org.junit.Assert
import org.junit.Test
import ru.netology.objects.*
import java.time.LocalDateTime

class WallServiceTest {

    @Test
    fun addTest() {
        val post = Post(123, 123, 5555, LocalDateTime.now(), "", 123, 123, false,
        Comments(1, canPost = false, groupsCanPost = false, canClose = false, canOpen = false), Copyright(123, "", "", ""),
            Like(5, userLikes = false, canLike = false, canPublish = false), Reposts(1, userReposted = true), View(2),
            PostType.POST, 123,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            Donut(isDonut = false, 6666, Placeholder(1233456), canPublishFreeCopy = false),
            123
        )
        val unExpectedId = 0
        Assert.assertNotEquals(unExpectedId, WallService.add(post).getId())
        WallService.posts.removeLast()
    }

    @Test
    fun updateTest_withValidId() {
        val post = Post(123, 123, 5555, LocalDateTime.now(), "", 123, 123, false,
            Comments(1, canPost = false, groupsCanPost = false, canClose = false, canOpen = false), Copyright(123, "", "", ""),
            Like(5, userLikes = false, canLike = false, canPublish = false), Reposts(1, userReposted = true), View(2),
            PostType.POST, 123,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            Donut(isDonut = false, 6666, Placeholder(1233456), canPublishFreeCopy = false),
            123
        )
        val expectedUpdate = true
        WallService.add(post)
        val isTrue = WallService.update(post)
        Assert.assertEquals(expectedUpdate, isTrue)
        WallService.posts.removeLast()
    }

    @Test
    fun updateTest_withInvalidId() {
        val post = Post(123, 123, 5555, LocalDateTime.now(), "", 123, 123, false,
            Comments(1, canPost = false, groupsCanPost = false, canClose = false, canOpen = false), Copyright(123, "", "", ""),
            Like(5, userLikes = false, canLike = false, canPublish = false), Reposts(1, userReposted = true), View(2),
            PostType.POST, 123,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            Donut(isDonut = false, 6666, Placeholder(1233456), canPublishFreeCopy = false),
            123
        )
        val expectedUpdate = false
        val isTrue = WallService.update(post)
        Assert.assertEquals(expectedUpdate, isTrue)
    }
}