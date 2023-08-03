package com.example.rickAndMorty.test.data.di

import com.example.rickAndMorty.test.data.network.ApiService
import com.example.rickAndMorty.test.data.repository.CharacterRepoImpl
import com.example.rickAndMorty.test.domain.repository.CharacterRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    val baseUrl= "https://rickandmortyapi.com/api/"

    @Singleton
    @Provides
    fun provideApiService(): ApiService{

        val logging =HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging);  // <-- this is the important line!


        return Retrofit.Builder().baseUrl(baseUrl).client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    fun provideCharacterRepo(apiService: ApiService): CharacterRepo {
        return CharacterRepoImpl(apiService)
    }


}