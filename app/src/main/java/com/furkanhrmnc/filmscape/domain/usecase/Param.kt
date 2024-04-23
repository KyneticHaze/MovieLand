package com.furkanhrmnc.filmscape.domain.usecase

import com.furkanhrmnc.filmscape.util.Category

data class Param(
    val category: Category,
    val page: Int = 1
)
