package com.tasneembohra.github.di

import com.google.gson.GsonBuilder
import com.tasneembohra.github.BuildConfig
import com.tasneembohra.github.remote.ApiProvider
import com.tasneembohra.github.remote.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val TIMEOUT = 60L

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()

        interceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.BASIC

        return interceptor
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder().create()

        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        val builder = OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)

        return builder.build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiProvider(apiService: ApiService): ApiProvider {
        return ApiProvider(apiService)
    }
}