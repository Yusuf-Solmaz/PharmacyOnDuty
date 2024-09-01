package com.yusuf.feature.pharmacy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.domain.use_case.GetCitiesUseCase
import com.yusuf.domain.use_case.GetPharmacyOnDutyByCityUseCase
import com.yusuf.domain.util.RootResult
import com.yusuf.feature.pharmacy.state.CityState
import com.yusuf.feature.pharmacy.state.PharmacyUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PharmacyViewModel @Inject constructor(
    private val getPharmacyByCityUseCase: GetPharmacyOnDutyByCityUseCase,
    private val getCitiesUseCase: GetCitiesUseCase
) : ViewModel() {

    private val _pharmacyUIState = MutableStateFlow(PharmacyUIState())
    internal val pharmacyUIState: StateFlow<PharmacyUIState> = _pharmacyUIState

    private val _cityState = MutableStateFlow(CityState())
    internal val cityState: StateFlow<CityState> = _cityState

    private val _districtState = MutableStateFlow(CityState())
    internal val districtState: StateFlow<CityState> = _districtState

    init {
        fetchCities()
    }

    fun fetchPharmacyByCity(city: String, district: String) {
        viewModelScope.launch {
            getPharmacyByCityUseCase(city, district).collect { result ->
                _pharmacyUIState.update { state ->
                    when (result) {
                        is RootResult.Error -> state.copy(isLoading = false, error = result.message)
                        RootResult.Loading -> state.copy(isLoading = true)
                        is RootResult.Success -> state.copy(isLoading = false, rootResponse = result.data)
                    }
                }
            }
        }
    }

    private fun fetchCities() {
        viewModelScope.launch {
            getCitiesUseCase().collect { result ->
                _cityState.update { state ->
                    when (result) {
                        is RootResult.Error -> state.copy(isLoading = false, error = result.message)
                        RootResult.Loading -> state.copy(isLoading = true)
                        is RootResult.Success -> state.copy(isLoading = false, cities = result.data)
                    }
                }
            }
        }
    }

    fun fetchDistricts(citySlug: String) {
        viewModelScope.launch {
            getCitiesUseCase(citySlug).collect { result ->
                _districtState.update { state ->
                    when (result) {
                        is RootResult.Error -> state.copy(isLoading = false, error = result.message)
                        RootResult.Loading -> state.copy(isLoading = true)
                        is RootResult.Success -> state.copy(isLoading = false, cities = result.data)
                    }
                }
            }
        }
    }
}
