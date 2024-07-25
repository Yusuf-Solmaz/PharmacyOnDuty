package com.yusuf.domain.repository.pharmacy

import com.yusuf.domain.model.pharmacy.PharmacyRoot
import com.yusuf.domain.util.RootResult
import kotlinx.coroutines.flow.Flow

interface PharmacyRepository {
    suspend fun getPharmacyOnDutyByCity(city: String, district: String): Flow<RootResult<PharmacyRoot>>
}