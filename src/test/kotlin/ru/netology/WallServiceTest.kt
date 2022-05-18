package ru.netology

import org.junit.Assert
import org.junit.Test
import ru.netology.objects.common.Comment
import ru.netology.objects.common.Report
import ru.netology.objects.wallservice.*
import java.time.LocalDateTime
import kotlin.Exception

class WallServiceTest {

    @Test
    fun addTest() {
        val post = Post(
            123, 123
        )
        val unExpectedId = 0
        Assert.assertNotEquals(unExpectedId, WallService.add(post).id)
        WallService.posts.removeLast()
    }

    @Test
    fun updateTest_withValidId() {
        val post = Post(123, 123)
        WallService.add(post)
        val isTrue = WallService.update(post)
        Assert.assertTrue(isTrue)
        WallService.posts.removeLast()
    }

    @Test
    fun updateTest_withInvalidId() {
        val post = Post(123, 123)
        val isTrue = WallService.update(post)
        Assert.assertFalse(isTrue)
    }

    @Test
    fun createComment_validComment() {
        val post = Post(123, 123)
        WallService.add(post)
        val comment = Comment(postId = 1)
        var ex: PostNotFoundException? = null
        try {
            WallService.createComment(comment)
        } catch (e: PostNotFoundException) {
            ex = e
        }
        Assert.assertEquals(null, ex)
        WallService.posts.removeLast()
        WallService.comments.removeLast()
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_invalidComment_throwException() {
        val post = Post(123, 123)
        WallService.add(post)
        val comment = Comment(postId = 3)
        WallService.createComment(comment)
    }

    @Test
    fun reportComment_validReport() {
        val post = Post(123, 123)
        WallService.add(post)
        val comment = Comment(ownerId = 123, 1)
        WallService.createComment(comment)
        val report = Report(1, 123)
        var ex: CommentNotFoundException? = null
        try {
            WallService.reportComment(report)
        } catch (e: CommentNotFoundException) {
            ex = e
        }
        Assert.assertEquals(null, ex)
        WallService.posts.removeLast()
        WallService.comments.removeLast()
        WallService.reports.removeLast()
    }

    @Test(expected = CommentNotFoundException::class)
    fun reportComment_invalidReport_throwException() {
        val post = Post(123, 123)
        WallService.add(post)
        val comment = Comment(ownerId = 123, 1)
        WallService.createComment(comment)
        val report = Report(1, 124)
        WallService.reportComment(report)
        WallService.posts.removeLast()
        WallService.comments.removeLast()
    }


}