package com.yusuf.feature.pharmacy

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.city.CityData
import com.yusuf.feature.pharmacy.state.PharmacyUIState
import com.yusuf.feature.pharmacy.viewmodel.PharmacyViewModel

@Composable
fun PharmacyOnDuty(viewModel: PharmacyViewModel = hiltViewModel()) {

    val pharmacyUIState by viewModel.pharmacyUIState.collectAsState()
    val cityState by viewModel.cityState.collectAsState()
    val districtState by viewModel.districtState.collectAsState()

    val cityExpanded = remember { mutableStateOf(false) }
    val selectedCity = remember { mutableStateOf("Select a city") }
    val selectedCitySlug = remember { mutableStateOf("") }

    val districtExpanded = remember { mutableStateOf(false) }
    val selectedDistrict = remember { mutableStateOf("Select a district") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (cityState.isLoading || districtState.isLoading) {
            Text(text = "Loading", modifier = Modifier.padding(16.dp))
        } else {
            Row (Modifier.fillMaxWidth(),
                horizontalArrangement = if(districtState.cities == null){
                    Arrangement.Center
                }
                else{
                    Log.e("PharmacyOnDutycities", districtState.cities.toString())
                    Arrangement.SpaceBetween
                }
            ){
                Row (Modifier.weight(1f)){
                    cityState.cities?.let {
                        CityDropdown(
                            cities = it,
                            selectedCity = selectedCity,
                            selectedCitySlug = selectedCitySlug,
                            cityExpanded = cityExpanded,
                            onCitySelected = { citySlug ->
                                viewModel.fetchDistricts(citySlug)
                            }
                        )
                    }
                }
                if (districtState.cities != null){
                    Row (Modifier.weight(1f)){
                        DistrictDropdown(
                            districts = districtState.cities!!,
                            selectedDistrict = selectedDistrict,
                            districtExpanded = districtExpanded,
                            onDistrictSelected = { districtSlug ->
                                viewModel.fetchPharmacyByCity(selectedCitySlug.value, districtSlug)
                            }
                        )
                    }
                }
            }
            PharmacyList(pharmacyUIState = pharmacyUIState)
        }
    }
}

@Composable
fun CityDropdown(
    cities: RootData<CityData>,
    selectedCity: MutableState<String>,
    selectedCitySlug: MutableState<String>,
    cityExpanded: MutableState<Boolean>,
    onCitySelected: (String) -> Unit
) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .clickable { cityExpanded.value = true }
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedCity.value,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Icon"
            )
        }

        DropdownMenu(
            modifier = Modifier.size(width = 150.dp, height = 200.dp),
            expanded = cityExpanded.value,
            onDismissRequest = { cityExpanded.value = false },
            offset =  DpOffset(x = 30.dp, y = 0.dp)
        ) {
            cities.data.forEach { city ->
                DropdownMenuItem(
                    text = { Text(text = city.cities) },
                    onClick = {
                        selectedCity.value = city.cities
                        selectedCitySlug.value = city.slug
                        cityExpanded.value = false
                        onCitySelected(city.slug)
                    }
                )
            }
        }
    }

@Composable
fun DistrictDropdown(
    districts: RootData<CityData>,
    selectedDistrict: MutableState<String>,
    districtExpanded: MutableState<Boolean>,
    onDistrictSelected: (String) -> Unit
) {
        Row(
            modifier = Modifier
                .clickable { districtExpanded.value = true }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedDistrict.value,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Icon"
            )
        }
        DropdownMenu(
            modifier = Modifier.size(width = 150.dp, height = 200.dp),
            expanded = districtExpanded.value,
            onDismissRequest = { districtExpanded.value = false }
        ) {
            districts.data.forEach { district ->
                DropdownMenuItem(
                    text = { Text(text = district.cities) },
                    onClick = {
                        selectedDistrict.value = district.cities
                        districtExpanded.value = false
                        onDistrictSelected(district.slug)
                    }
                )
            }
        }
}

@Composable
internal fun PharmacyList(pharmacyUIState: PharmacyUIState) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            pharmacyUIState.isLoading -> Text(text = "Loading")
            pharmacyUIState.error != null -> {
                Text(text = pharmacyUIState.error)
                Log.e("PharmacyOnDuty", pharmacyUIState.error)
            }
            pharmacyUIState.rootDataResponse != null -> {
                LazyColumn {
                    items(pharmacyUIState.rootDataResponse.data.size) { index ->
                        Text(text = pharmacyUIState.rootDataResponse.data[index].pharmacyName)
                    }
                }
            }
        }
    }
}
