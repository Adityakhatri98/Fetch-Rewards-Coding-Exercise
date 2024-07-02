package com.example.fetchrewardscodingexercise.repository

import com.example.fetchrewardscodingexercise.network.RewardsService
import com.example.fetchrewardscodingexercise.network.model.RewardsListItem
import javax.inject.Inject

class RewardsRepositoryImpl @Inject constructor(
    private val rewardsService: RewardsService):RewardsRepository {

    override suspend fun getRewards(): List<RewardsListItem> {
        return rewardsService.getRewardsDetails()
    }

}