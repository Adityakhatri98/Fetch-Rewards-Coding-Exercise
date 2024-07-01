package com.example.fetchrewardscodingexercise.dagger

import android.app.Application
import com.example.fetchrewardscodingexercise.FetchRewardCEApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(private val application: FetchRewardCEApplication) {

    @Provides
    @Singleton
    fun getApplication(): Application {
        return application
    }
}