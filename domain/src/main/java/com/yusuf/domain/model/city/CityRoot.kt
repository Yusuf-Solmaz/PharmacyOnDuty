package com.yusuf.domain.model.city

data class CityRoot(
    val creditUsed: Int,
    val `data`: List<Data>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)