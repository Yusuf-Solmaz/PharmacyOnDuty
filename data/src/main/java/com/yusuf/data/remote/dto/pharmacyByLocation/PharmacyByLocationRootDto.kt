package com.yusuf.domain.model.pharmacyByLocation

data class PharmacyByLocationRootDto(
    val creditUsed: Int,
    val `data`: List<DataDto>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)