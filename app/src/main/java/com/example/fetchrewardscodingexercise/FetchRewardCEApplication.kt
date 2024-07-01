package com.example.fetchrewardscodingexercise

import android.app.Application
import com.example.fetchrewardscodingexercise.dagger.AppComponent
import com.example.fetchrewardscodingexercise.dagger.AppModule
import com.example.fetchrewardscodingexercise.dagger.DaggerAppComponent

/**
 * The application class - an entry point into our app where we initialize Dagger.
 */
class FetchRewardCEApplication :Application(){
    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDaggerAppComponent()
    }

    private fun initDaggerAppComponent(): AppComponent {
        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        return appComponent
    }
}