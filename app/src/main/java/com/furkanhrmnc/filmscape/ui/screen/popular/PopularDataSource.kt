package com.furkanhrmnc.filmscape.ui.screen.popular

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.furkanhrmnc.filmscape.domain.model.Media
import com.furkanhrmnc.filmscape.domain.model.PaginatedData
import com.furkanhrmnc.filmscape.domain.repository.MediaRepository
import com.furkanhrmnc.filmscape.util.Result
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class PopularDataSource(
    private val type: String,
    private val repo: MediaRepository,
) : PagingSource<Int, Media>() {
    override fun getRefreshKey(state: PagingState<Int, Media>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.run {
                prevKey?.plus(1) ?: nextKey?.minus(1)
            }
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Media> =
        runCatching {
            loadPage(
                type = type,
                page = params.key ?: 1
            )
        }
            .fold(
                onSuccess = { result ->
                    LoadResult.Page(
                        data = result.results,
                        prevKey = result.prevKey(),
                        nextKey = result.nextKey()
                    )
                },
                onFailure = { throwable ->
                    LoadResult.Error(
                        throwable = throwable
                    )
                }
            )

    private fun PaginatedData<Media>.prevKey(): Int? =
        if (page == 1) null else page.minus(1)

    private fun PaginatedData<Media>.nextKey(): Int? =
        if (page >= totalPages) null else page.plus(1)


    private suspend fun loadPage(
        type: String,
        timeWindow: String = "day",
        page: Int,
    ): PaginatedData<Media> {
        return repo.getTrendingMovieOrTv(
            type = type,
            timeWindow = timeWindow,
            page = page
        )
            .onEach { result -> if (result is Result.Failure) throw result.throwable }
            .map { result -> (result as Result.Success).data }
            .first()
    }
}