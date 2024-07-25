package com.yusuf.data.mapper

import com.yusuf.domain.model.city.CityRoot
import com.yusuf.domain.model.city.CityRootDto
import com.yusuf.domain.model.city.Data
import com.yusuf.domain.model.city.DataDto

fun CityRootDto.toCityRoot(): CityRoot {
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


fun DataDto.toData(): Data {
    return Data(
        cities = cities,
        slug = slug
    )

}