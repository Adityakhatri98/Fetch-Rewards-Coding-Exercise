package com.example.fetchrewardscodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchrewardscodingexercise.features.rewardsdetails.RewardsDetailsFragement
import com.example.fetchrewardscodingexercise.ui.theme.FetchRewardsCodingExerciseTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rewardsDetailsFragement = RewardsDetailsFragement()

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,rewardsDetailsFragement
            )
            .commit()
    }
}
