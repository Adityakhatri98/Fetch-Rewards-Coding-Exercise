package com.example.fetchrewardscodingexercise.features.rewardsdetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardscodingexercise.network.model.RewardsListItem
import com.example.fetchrewardscodingexercise.repository.RewardsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class RewardsViewModel @Inject constructor(private val rewardsRepository: RewardsRepository):ViewModel() {

    private val rewardsData : MutableLiveData<List<RewardsListItem>> = MutableLiveData()

    init {
        getRewardsDetails()
    }

    fun getRewardsDetails() = viewModelScope.launch {
        try {
            val resp = rewardsRepository.getRewards()
            val processedData = resp
                .filter { !it.name.isNullOrBlank() }
//                .filter { it.name.isNotBlank() }

                .sortedWith(compareBy({ it.listId }, { it.name }))
                .groupBy { it.listId }
                .flatMap { entry -> entry.value }
            rewardsData.value = processedData
            Log.d("@#$@" ,"check view model")
            Log.d("@#$@" ,"rp $resp")
        }catch (t:Throwable){
            Log.d("@#$@" ,"error $t")
        }
    }
    fun observeRewardsDetails():MutableLiveData<List<RewardsListItem>>{
        return rewardsData
    }
}