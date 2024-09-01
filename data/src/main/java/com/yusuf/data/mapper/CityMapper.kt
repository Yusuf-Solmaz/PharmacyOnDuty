package com.yusuf.data.mapper

import com.yusuf.domain.model.city.CityRoot
import com.yusuf.data.remote.dto.city.CityRootDto
import com.yusuf.domain.model.city.Data
import com.yusuf.data.remote.dto.city.DataDto

internal fun CityRootDto.toCityRoot(): CityRoot {
    return CityRoot(
        creditUsed = creditUsed,
        data = data.map { it.toData() },
        endpoint = endpoint,
        message = message,
        messageTR = messageTR,
        rowCount = rowCount,
        status = status,
        systemTime = systemTime
    )
}


internal fun DataDto.toData(): Data {
    return Data(
        cities = cities,
        slug = slug
    )

}