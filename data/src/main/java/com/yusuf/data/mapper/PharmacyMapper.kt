package com.yusuf.data.mapper

import com.yusuf.data.remote.dto.base.RootDataDto
import com.yusuf.data.remote.dto.pharmacy.PharmacyDataDto
import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.pharmacy.PharmacyData

internal fun PharmacyDataDto.toPharmacyData(): PharmacyData {
    return PharmacyData(
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

internal fun RootDataDto<PharmacyDataDto>.toPharmacyRoot(): RootData<PharmacyData> {
    return this.toRoot { it.toPharmacyData() }
}