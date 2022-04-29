package ru.netology

import org.junit.Assert
import org.junit.Test
import ru.netology.objects.*
import java.time.LocalDateTime

class WallServiceTest {

    @Test
    fun addTest() {
        val post = Post(
            123, 123, null, LocalDateTime.now(), "Hello Kotlin!", null, null,
            false, Comments(), null, Like(), null, View(), postSource = null, geo = Geo("Nature", "25.25",
                Place(2525, "Moscow", 25, 25, 156987, "some url", address = "Lenin's avenue")), signerId = null,
            copyHistory = null, donut = null
        )
        val unExpectedId = 0
        Assert.assertNotEquals(unExpectedId, WallService.add(post).getId())
        WallService.posts.removeLast()
    }

    @Test
    fun updateTest_withValidId() {
        val post = Post(123, 123, null, LocalDateTime.now(), "Hello Kotlin!", null, null,
            false, Comments(), null, Like(), null, View(), postSource = null, geo = Geo("Nature", "25.25",
                Place(2525, "Moscow", 25, 25, 156987, "some url", address = "Lenin's avenue")), signerId = null,
            copyHistory = null, donut = null
        )
        WallService.add(post)
        val isTrue = WallService.update(post)
        Assert.assertTrue(isTrue)
        WallService.posts.removeLast()
    }

    @Test
    fun updateTest_withInvalidId() {
        val post = Post(123, 123, null, LocalDateTime.now(), "Hello Kotlin!", null, null,
            false, Comments(), null, Like(), null, View(), postSource = null, geo = Geo("Nature", "25.25",
                Place(2525, "Moscow", 25, 25, 156987, "some url", address = "Lenin's avenue")), signerId = null,
            copyHistory = null, donut = null
        )
        val isTrue = WallService.update(post)
        Assert.assertFalse(isTrue)
    }
}