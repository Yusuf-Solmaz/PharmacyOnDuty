package com.yusuf.data.remote

import com.yusuf.data.BuildConfig
import com.yusuf.data.remote.dto.base.RootDataDto
import com.yusuf.data.remote.dto.city.CityDataDto
import com.yusuf.data.remote.dto.pharmacy.PharmacyDataDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PharmacyApi {

    @GET("pharmacies-on-duty")
    suspend fun getPharmaciesOnDuty(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("city") city: String,
        @Query("district") district: String
    ): RootDataDto<PharmacyDataDto>

    @GET("pharmacies-on-duty/cities")
    suspend fun getCities(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("city") city: String? = null
    ): RootDataDto<CityDataDto>

}