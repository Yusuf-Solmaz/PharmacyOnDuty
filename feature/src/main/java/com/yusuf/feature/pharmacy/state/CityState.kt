package com.yusuf.feature.pharmacy.state

import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.city.CityData

internal data class CityState(
    val isLoading: Boolean = false,
    val cities: RootData<CityData>? = null,
    val error: String? = ""

)