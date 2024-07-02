package com.example.fetchrewardscodingexercise.dagger

import android.app.Application
import com.example.fetchrewardscodingexercise.FetchRewardCEApplication
import com.example.fetchrewardscodingexercise.network.RewardsService
import com.example.fetchrewardscodingexercise.repository.RewardsRepository
import com.example.fetchrewardscodingexercise.repository.RewardsRepositoryImpl
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

    @Provides
    fun providesRepo(rewardsService: RewardsService):RewardsRepository{
        return RewardsRepositoryImpl(rewardsService)
    }
}