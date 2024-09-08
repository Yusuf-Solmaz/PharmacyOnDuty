package com.yusuf.feature.pharmacy.state

import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.pharmacy.PharmacyData

internal data class PharmacyUIState  (
    val isLoading: Boolean = false,
    val rootDataResponse: RootData<PharmacyData>? =null,
    val error: String?= null
    )
