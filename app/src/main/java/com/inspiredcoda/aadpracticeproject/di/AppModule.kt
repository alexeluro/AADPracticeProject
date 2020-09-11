package com.inspiredcoda.aadpracticeproject.di

import android.content.Context
import com.facebook.stetho.okhttp3.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.inspiredcoda.aadpracticeproject.data.GADSRecordsApi
import com.inspiredcoda.aadpracticeproject.data.GADSSubmit
import com.inspiredcoda.aadpracticeproject.data.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    @RecordsApi
    @Singleton
    @Provides
    fun provideRetrofitForRecords(@ApplicationContext context: Context): Retrofit{
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(com.inspiredcoda.aadpracticeproject.BuildConfig.RECORDS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @SubmissionApi
    @Singleton
    @Provides
    fun provideRetrofitForSubmission(@ApplicationContext context: Context): Retrofit{

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(com.inspiredcoda.aadpracticeproject.BuildConfig.SUBMIT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }


    @Singleton
    @Provides
    fun provideGADSRecordsApi(@RecordsApi retrofit: Retrofit): GADSRecordsApi{
        return retrofit.create(GADSRecordsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideGADSSubmissionApi(@SubmissionApi retrofit: Retrofit): GADSSubmit{
        return retrofit.create(GADSSubmit::class.java)
    }


    @Provides
    fun provideHomeRepository(records: GADSRecordsApi) = HomeRepository(records)



    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RecordsApi

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SubmissionApi

}