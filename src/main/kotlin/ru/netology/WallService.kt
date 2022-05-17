package ru.netology

object WallService {
    var posts = mutableListOf<Post>()

    fun add(post: Post): Post {
        posts.add(post)
        post.id = posts.size
        return posts.last()
    }

    fun update(post: Post): Boolean {
        return if (posts.find { it.id == post.id } != null) {
            posts[post.id - 1] = post.copy(
                text = post.text,
                friendsOnly = post.friendsOnly,
                comments = post.comments,
                likes = post.likes,
                reposts = post.reposts,
                views = post.views,
                postType = post.postType,
                canPin = post.canPin,
                canDelete = post.canDelete,
                canEdit = post.canEdit,
                isPinned = post.isPinned,
                markedAsAds = post.markedAsAds,
                isFavorite = post.isFavorite,
                donut = post.donut,
                postponedId = post.postponedId
            )
            true
        }
        else false
    }
}