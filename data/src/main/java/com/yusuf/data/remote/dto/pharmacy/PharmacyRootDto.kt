package com.yusuf.domain.model.pharmacy

data class PharmacyRootDto(
    val creditUsed: Int,
    val `data`: List<DataDto>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)