package com.yusuf.data.repository

import com.yusuf.data.mapper.toCityRoot
import com.yusuf.data.remote.PharmacyApi
import com.yusuf.domain.model.base.RootData
import com.yusuf.domain.model.city.CityData
import com.yusuf.domain.repository.city.CityRepository
import com.yusuf.domain.util.RootResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val api: PharmacyApi
): CityRepository {

    override fun getCities(city: String?): Flow<RootResult<RootData<CityData>>> = flow {
        emit(RootResult.Loading)
        try {
            val response = api.getCities(city = city)
            emit(RootResult.Success(response.toCityRoot()))
        } catch (e: Exception) {
            emit(RootResult.Error(e.message ?: "Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)


}
