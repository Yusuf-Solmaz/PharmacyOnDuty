package com.yusuf.domain.use_case

import com.yusuf.domain.repository.city.CityRepository
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(
    private val repository: CityRepository
) {
    operator fun invoke(city: String? = null) = repository.getCities(city)
}