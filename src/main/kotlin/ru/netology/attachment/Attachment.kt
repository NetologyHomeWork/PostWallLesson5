package ru.netology.attachment

import ru.netology.objects.wallservice.Like
import ru.netology.objects.wallservice.Place
import ru.netology.objects.wallservice.Reposts

sealed class Attachment(val type: String) {

    data class Photo(
        val id: Int,
        val album_id: Int,
        val ownerId: Int,
        val userId: Int,
        val text: String,
        val date: Int
    ) : Attachment("photo")

    data class Audio(
        val id: Int,
        val ownerId: Int, //Идентификатор владельца аудиозаписи.
        val artist: String, // Исполнитель.
        val title: String, //Название композиции.
        val duration: Int, //Длительность аудиозаписи в секундах.
        val url: String, //Ссылка на mp3.
        val lyricsId: Boolean, //Идентификатор текста аудиозаписи (если доступно).
        val albumId: Boolean, //Идентификатор альбома, в котором находится аудиозапись (если присвоен).
        val genreId: Int, // Идентификатор жанра из списка аудио жанров.
        val date: Int, // Дата добавления.
        val noSearch: Boolean, // Опция «Не выводить при поиске». Если опция отключена, поле не возвращается.
        val isHq: Boolean // если аудио в высоком качестве.
    ) : Attachment("audio")

    data class Video(
        val id: Int,
        val ownerId: Int,
        val title: String,
        val description: String,
        val duration: Int,
        val date: Int,
        val addingDate: Int,
        val views: Int,
        val localViews: Int,
        val comments: Int,
        val player: String,
        val platform: String,
        val canAdd: Boolean,
        val isPrivate: Boolean,
        val accessKey: String,
        val processing: Boolean,
        val isFavorite: Boolean,
        val canComment: Boolean,
        val canEdit: Boolean,
        val canLike: Boolean,
        val canRepost: Boolean,
        val canSubscribe: Boolean,
        val canAddToFaves: Boolean,
        val canAttachLink: Boolean,
        val width: Int,
        val height: Int,
        val userId: Int,
        val converting: Boolean,
        val added: Boolean,
        val isSubscribed: Boolean,
        val repeat: Boolean,
        val typeVideo: String,
        val balance: Int,
        val liveStatus: String,
        val live: Boolean,
        val upcoming: Boolean,
        val spectators: Int,
        val likes: Like,
        val reposts: Reposts
    ) : Attachment("video")

    data class File(
        val id: Int,
        val ownerId: Int,
        val title: String,
        val size: Int,
        val ext: String,
        val url: String,
        val data: TypeFile,
        val preview: Preview
    ) : Attachment("file")

    data class Sticker(
        val id: Int,
        val stickerId: Int,
        val images: ArrayList<Image>,
        val imagesWithBackground: ArrayList<ImageWithBackground>,
        val animationUrl: String,
        val isAllowed: Boolean
    ) : Attachment("sticker") {
        class Image(url: String, width: Int, height: Int)
        class ImageWithBackground(url: String, width: Int, height: Int)
    }

    data class Link(
        val url: String,
        val title: String,
        val caption: String?,
        val description: String,
        val photo: Preview.Photo?,
        val product: Product,
        val button: Button,
        val previewPage: String,
        val previewUrl: String
    ) : Attachment("link") {
        class Product(price: Price) {
            class Price(amount: Int, currency: Currency, text: String) {
                class Currency(id: Int, name: String)
            }
        }

        class Button(title: String, action: Action) {
            class Action(type: String, url: String)
        }
    }

    data class Gift(
        val id: Int,
        val thumb256: String,
        val thumb96: String,
        val thumb48: String,
    )

    data class GeoLabel(
        val typeGeo: String,
        val coordinates: Coordinates,
        val place: Place
    ) : Attachment("geo label") {
        class Coordinates(latitude: Int, longitude: Int)
    }

    data class History(
        val id: Int,
        val ownerId: Int,
        val date: Int,
        val expiresAt: Int,
        val isExpired: Boolean, //true, если срок хранения истории истёк. В этом случае объект истории содержит только поля id, owner_id, date, expires_at, is_expired.
        val isDeleted: Boolean?, // true, если история удалена или не существует. В этом случае объект истории содержит только поля id, owner_id, is_deleted.
        val canSee: Int?, // Информация о том, может ли пользователь просмотреть историю (0 — нет, 1 — да). Если can_see = 0, объект истории содержит только поля id, owner_id, date, expires_at, can_see, type.
        val seen: Boolean?,
        val typeHistory: TypeHistory?,
        val photo: Photo?,
        val video: Video?,
        val link: Link?,
        val parentStoryOwnerId: Int?,
        val parentStoryId: Int?,
        val parentStory: History?,
        val replies: Reply?,
        val canReply: Int?,
        val canShare: Int?,
        val canComment: Int?,
        val clickableStickers: ClickableSticker?,
        val views: Int?,
        val accessKey: String?
    ) : Attachment("history") {
        enum class TypeHistory {
            Photo, Video
        }

        class Link(text: String, url: String)
        class Reply(count: Int, new: Int)
    }

    data class ClickableSticker(
        val originalWidth: Int,
        val originalHeight: Int,
        val clickableStickers: ArrayList<ClickableSticker>
    ) : Attachment("clickable stickers")

    data class Graffiti(
        val id: Int,
        val ownerId: Int,
        val url: String,
        val width: Int,
        val height: Int
    ) : Attachment("graffiti")
}
