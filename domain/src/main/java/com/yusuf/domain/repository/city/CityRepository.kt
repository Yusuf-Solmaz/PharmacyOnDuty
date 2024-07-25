package com.yusuf.domain.repository.city

import com.yusuf.domain.model.city.CityRoot
import com.yusuf.domain.util.GeneralResult
import kotlinx.coroutines.flow.Flow

interface CityRepository {

    suspend fun getCities() : Flow<GeneralResult<CityRoot>>

    suspend fun getDistricts(city: String) : Flow<GeneralResult<CityRoot>>
}