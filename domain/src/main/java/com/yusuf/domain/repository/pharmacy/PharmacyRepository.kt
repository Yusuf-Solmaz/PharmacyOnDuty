package com.yusuf.domain.repository.pharmacy

import com.yusuf.domain.model.pharmacy.PharmacyRoot
import com.yusuf.domain.util.GeneralResult
import kotlinx.coroutines.flow.Flow

interface PharmacyRepository {

    suspend fun getPharmacyOnDutyByCity(city: String) : Flow<GeneralResult<PharmacyRoot>>

}