package com.furkanhrmnc.filmscape.domain.model

data class PersonDetail(
    val adult: Boolean,
    val alsoKnownAs: List<String>,
    val biography: String,
    val birthDay: String,
    val deathDay: String?,
    val gender: Int,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val knownForDepartment: String,
    val name: String,
    val placeOfBirth: String?,
    val popularity: Double,
    val profilePath: String,
)