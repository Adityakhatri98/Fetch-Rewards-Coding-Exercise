package com.example.fetchrewardscodingexercise.repository

import com.example.fetchrewardscodingexercise.network.model.RewardsListItem

interface RewardsRepository {

    suspend fun getRewards():List<RewardsListItem>
}