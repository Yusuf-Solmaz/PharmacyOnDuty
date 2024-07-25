package com.yusuf.domain.repository.city

import com.yusuf.domain.model.city.CityRoot
import com.yusuf.domain.util.RootResult
import kotlinx.coroutines.flow.Flow

interface CityRepository {

    suspend fun getCities() : Flow<RootResult<CityRoot>>

    suspend fun getDistricts(city: String) : Flow<RootResult<CityRoot>>
}