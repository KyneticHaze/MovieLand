package com.furkanhrmnc.filmscape.di

import com.furkanhrmnc.filmscape.data.remote.api.MovieApi
import com.furkanhrmnc.filmscape.data.remote.repository.MovieRepositoryImpl
import com.furkanhrmnc.filmscape.domain.repository.MovieRepository
import com.furkanhrmnc.filmscape.util.ApiConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {

    single<Interceptor> {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single {
        OkHttpClient().newBuilder().addInterceptor(get<Interceptor>())
            .readTimeout(TIMEOUT.READ_TIMEOUT.time, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT.CONNECT_TIMEOUT.time, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT.WRITE_TIMEOUT.time, TimeUnit.SECONDS)
            .build()
    }


    single<MovieApi> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(ApiConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
}

enum class TIMEOUT(val time: Long) {
    READ_TIMEOUT(60),
    CONNECT_TIMEOUT(60),
    WRITE_TIMEOUT(60)
}