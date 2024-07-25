package com.yusuf.feature.pharmacy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PharmacyOnDuty(viewModel: PharmacyViewModel= hiltViewModel()) {

    val pharmacyOnDutyState by viewModel.rootPharmacyState.collectAsState(PharmacyUIState())
    if (pharmacyOnDutyState.isLoading) {
        Text(text = "Loading")
    }
    if (pharmacyOnDutyState.error != null) {
        Text(text = pharmacyOnDutyState.error.toString())
    }
    if (pharmacyOnDutyState.rootResponse != null) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = pharmacyOnDutyState.rootResponse!!.data[0].pharmacyName)
        }

    }

}