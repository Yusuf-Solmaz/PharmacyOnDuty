package com.yusuf.feature.pharmacy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf.data.repository.PharmacyRepositoryImpl
import com.yusuf.domain.repository.pharmacy.PharmacyRepository
import com.yusuf.domain.util.RootResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PharmacyViewModel @Inject constructor(
    private val pharmacyRepository: PharmacyRepositoryImpl
): ViewModel() {

    private val _rootPharmacyState = MutableStateFlow(PharmacyUIState())
    val rootPharmacyState: Flow<PharmacyUIState> = _rootPharmacyState

    init{
        getPharmacyByCity("kutahya","tavsanli")
    }

    fun getPharmacyByCity(city: String, district: String) {
        viewModelScope.launch {
            pharmacyRepository.getPharmacyOnDutyByCity(city = city, district = district)
                .collect { result ->
                    when (result) {
                        is RootResult.Error -> {
                            _rootPharmacyState.update {
                                it.copy(
                                    isLoading = false,
                                    error = result.message
                                )
                            }
                        }

                        RootResult.Loading -> {
                            _rootPharmacyState.update {
                                it.copy(
                                    isLoading = true
                                )
                            }
                        }

                        is RootResult.Success -> {
                            _rootPharmacyState.update {
                                it.copy(
                                    isLoading = false,
                                    rootResponse = result.data
                                )
                            }
                        }
                    }
                }
        }
    }
}