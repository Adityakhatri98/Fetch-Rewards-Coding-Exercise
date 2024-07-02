package com.example.fetchrewardscodingexercise.dagger

import com.example.fetchrewardscodingexercise.FetchRewardCEApplication
import com.example.fetchrewardscodingexercise.features.rewardsdetails.RewardsDetailsFragement
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app:FetchRewardCEApplication)
    fun inject(rewardsDetailsFragement: RewardsDetailsFragement)
}