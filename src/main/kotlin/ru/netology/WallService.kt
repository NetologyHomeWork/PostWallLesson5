package ru.netology

object WallService {
    var posts = ArrayList<Post>()


    fun add(post: Post): Post {
        posts.add(post)
        post.setId(posts.size)
        return posts.last()
    }

    fun update(post: Post): Boolean {

        if (posts.find { it.getId() == post.getId() } != null) {
            posts[post.getId() - 1] = post.copy(
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
            return true
        }
        else return false
    }
}