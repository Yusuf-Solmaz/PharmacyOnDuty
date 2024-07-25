package com.yusuf.pharmacyonduty

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.yusuf.feature.pharmacy.PharmacyOnDuty
import com.yusuf.pharmacyonduty.ui.theme.PharmacyOnDutyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PharmacyOnDutyTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), content = {
                    PharmacyOnDuty()
                })
            }
        }
    }
}