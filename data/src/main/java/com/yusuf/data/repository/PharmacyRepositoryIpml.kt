package com.yusuf.data.repository

import com.yusuf.data.mapper.toPharmacyRoot
import com.yusuf.data.remote.PharmacyApi
import com.yusuf.domain.model.pharmacy.PharmacyRoot
import com.yusuf.domain.repository.pharmacy.PharmacyRepository
import com.yusuf.domain.util.RootResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PharmacyRepositoryImpl @Inject constructor(
    private val api: PharmacyApi
) : PharmacyRepository {

     override suspend fun getPharmacyOnDutyByCity(city: String, district: String): Flow<RootResult<PharmacyRoot>> = flow {
        try {
            emit(RootResult.Loading)
            val response =api.getPharmaciesOnDuty(city = city, district = district)
            emit(RootResult.Success(response.toPharmacyRoot()))
        }
        catch (e:Exception){
            emit(RootResult.Error(e.message ?: "Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)

}