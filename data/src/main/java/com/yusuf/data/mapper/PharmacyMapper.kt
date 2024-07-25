package com.yusuf.data.mapper

import com.yusuf.domain.model.pharmacy.Data
import com.yusuf.domain.model.pharmacy.DataDto
import com.yusuf.domain.model.pharmacy.PharmacyRoot
import com.yusuf.domain.model.pharmacy.PharmacyRootDto

fun PharmacyRootDto.toPharmacyRoot(): PharmacyRoot{
    return PharmacyRoot(
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
        address = address,
        city = city,
        directions = directions,
        district = district,
        latitude = latitude,
        longitude = longitude,
        pharmacyDutyEnd = pharmacyDutyEnd,
        pharmacyDutyStart = pharmacyDutyStart,
        pharmacyID = pharmacyID,
        pharmacyName = pharmacyName,
        phone = phone,
        phone2 = phone2,
        town = town
    )
}