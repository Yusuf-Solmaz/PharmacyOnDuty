package com.yusuf.data.remote.dto.pharmacy

data class DataDto(
    val address: String,
    val city: String,
    val directions: String,
    val district: String,
    val latitude: Double,
    val longitude: Double,
    val pharmacyDutyEnd: String,
    val pharmacyDutyStart: String,
    val pharmacyID: Int,
    val pharmacyName: String,
    val phone: String,
    val phone2: String,
    val town: String
)