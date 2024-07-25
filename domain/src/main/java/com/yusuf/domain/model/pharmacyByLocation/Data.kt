package com.yusuf.domain.model.pharmacyByLocation

data class Data(
    val address: String,
    val city: String,
    val directions: String,
    val distanceKm: Double,
    val distanceMil: Double,
    val distanceMt: Int,
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