package com.yusuf.data.mapper

import com.yusuf.data.remote.dto.base.RootDataDto
import com.yusuf.domain.model.base.RootData

internal fun <T, R> RootDataDto<T>.toRoot(mapper: (T) -> R): RootData<R> {
    return RootData(
        creditUsed = creditUsed,
        data = data.map(mapper),
        endpoint = endpoint,
        message = message,
        messageTR = messageTR,
        rowCount = rowCount,
        status = status,
        systemTime = systemTime
    )
}

internal fun <T, R> List<T>.mapToDomain(mapper: (T) -> R): List<R> {
    return this.map(mapper)
}
