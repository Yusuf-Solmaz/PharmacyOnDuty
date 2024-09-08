package com.yusuf.domain.repository.pharmacy

import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.pharmacy.PharmacyData
import com.yusuf.domain.util.RootResult
import kotlinx.coroutines.flow.Flow

interface PharmacyRepository {
    fun getPharmacyOnDutyByCity(city: String, district: String): Flow<RootResult<RootData<PharmacyData>>>
}