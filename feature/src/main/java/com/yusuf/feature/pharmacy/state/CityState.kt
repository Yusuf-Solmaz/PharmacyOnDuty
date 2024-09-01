package com.yusuf.feature.pharmacy.state

import com.yusuf.domain.model.city.CityRoot

internal data class CityState(
    val isLoading: Boolean = false,
    val cities: CityRoot? = null,
    val error: String? = ""

)