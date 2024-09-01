package com.yusuf.domain.repository.city

import com.yusuf.domain.model.city.CityRoot
import com.yusuf.domain.util.RootResult
import kotlinx.coroutines.flow.Flow

interface CityRepository {

    fun getCities(city: String? = null) : Flow<RootResult<CityRoot>>

}