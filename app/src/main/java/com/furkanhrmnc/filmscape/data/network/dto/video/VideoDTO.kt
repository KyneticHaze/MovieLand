package com.furkanhrmnc.filmscape.data.network.dto.video


import com.furkanhrmnc.filmscape.domain.model.Video
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoDTO(
    @SerialName("id")
    val id: String?,
    @SerialName("iso_3166_1")
    val iso31661: String?,
    @SerialName("iso_639_1")
    val iso6391: String?,
    @SerialName("key")
    val key: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("official")
    val official: Boolean?,
    @SerialName("published_at")
    val publishedAt: String?,
    @SerialName("site")
    val site: String?,
    @SerialName("size")
    val size: Int?,
    @SerialName("type")
    val type: String?,
)


fun VideoDTO.toVideo() = Video(
    id = id ?: "",
    name = name ?: "",
    iso31661 = iso31661 ?: "",
    iso6391 = iso6391 ?: "",
    publishedAt = publishedAt ?: "",
    site = site ?: "",
    size = size ?: 0,
    type = type ?: "",
    key = key ?: "",
    official = official ?: false,
)