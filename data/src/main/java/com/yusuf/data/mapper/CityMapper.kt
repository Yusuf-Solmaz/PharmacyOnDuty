package com.yusuf.data.mapper

import com.yusuf.data.remote.dto.base.RootDataDto
import com.yusuf.data.remote.dto.city.CityDataDto
import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.city.CityData

internal fun CityDataDto.toCityData(): CityData {
    return CityData(
        cities = cities,
        slug = slug
    )
}

internal fun RootDataDto<CityDataDto>.toCityRoot(): RootData<CityData> {
    return this.toRoot { it.toCityData() }
}