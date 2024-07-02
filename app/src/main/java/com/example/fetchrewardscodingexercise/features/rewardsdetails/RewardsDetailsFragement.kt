package com.example.fetchrewardscodingexercise.features.rewardsdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexercise.FetchRewardCEApplication
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject



/**
 *
 */
class RewardsDetailsFragement : Fragment(),OnItemValueChangedListener {
    private lateinit var rewardsAdapter: RewardsDetailsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var tv: TextView

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<RewardsViewModel>

    private val viewModel: RewardsViewModel by lazy {
        viewModelFactory.get<RewardsViewModel>(requireActivity())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        FetchRewardCEApplication.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_rewards_details, container, false)

        rewardsAdapter = RewardsDetailsAdapter(this)
        recyclerView = view.findViewById(R.id.rv_rewards)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = rewardsAdapter
        tv = view.findViewById(R.id.tv_current_list_id)


        Log.d("@#$@","check")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("@#$@", "Data 1")
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.observeRewardsDetails().observe(viewLifecycleOwner, Observer { data->
                if (data != null) {
                    rewardsAdapter.differ.submitList(data)

                    Log.d("@#$@", "Data observed: $data")
                } else {
                 Log.d("@#$@", "No data observed")
            }
            })
        }
    }

    override fun onItemValueChanged(newValue: String) {
        tv.text =newValue
    }


}