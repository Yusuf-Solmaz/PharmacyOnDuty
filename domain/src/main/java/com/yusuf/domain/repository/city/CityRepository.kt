package com.yusuf.domain.repository.city

import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.city.CityData
import com.yusuf.domain.util.RootResult
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    fun getCities(city: String? = null): Flow<RootResult<RootData<CityData>>>
}