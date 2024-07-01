package com.example.fetchrewardscodingexercise.network

import com.example.fetchrewardscodingexercise.network.model.RewardsListItem
import retrofit2.http.GET

interface RewardsService {

    @GET("hiring.json")
    suspend fun getRewardsDetails():List<RewardsListItem>
}