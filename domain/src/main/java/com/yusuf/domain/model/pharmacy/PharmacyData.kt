package com.yusuf.domain.model.pharmacy

data class PharmacyData(
    val address: String? = "",
    val city: String? = "",
    val directions: String? = "",
    val district: String? = "",
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0,
    val pharmacyDutyEnd: String? = "",
    val pharmacyDutyStart: String? = "",
    val pharmacyID: Int? = 0,
    val pharmacyName: String = "",
    val phone: String? = "",
    val phone2: String? = "",
    val town: String? = ""
)