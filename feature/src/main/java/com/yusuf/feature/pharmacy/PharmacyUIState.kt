package com.yusuf.feature.pharmacy

import com.yusuf.domain.model.pharmacy.PharmacyRoot

data class PharmacyUIState  (
    val isLoading: Boolean = false,
    val rootResponse: PharmacyRoot? =null,
    val error: String?= null
    )
