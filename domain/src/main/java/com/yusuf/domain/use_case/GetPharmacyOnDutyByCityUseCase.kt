package com.yusuf.domain.use_case

import com.yusuf.domain.repository.pharmacy.PharmacyRepository
import javax.inject.Inject

class GetPharmacyOnDutyByCityUseCase @Inject constructor(
    private val pharmacyRepository: PharmacyRepository
){
    operator fun invoke(city: String, district: String) = pharmacyRepository.getPharmacyOnDutyByCity(city = city, district = district)

}