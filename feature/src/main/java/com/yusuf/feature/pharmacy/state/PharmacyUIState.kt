package com.yusuf.feature.pharmacy.state

import com.yusuf.domain.model.pharmacy.PharmacyRoot

internal data class PharmacyUIState  (
    val isLoading: Boolean = false,
    val rootResponse: PharmacyRoot? =null,
    val error: String?= null
    )
