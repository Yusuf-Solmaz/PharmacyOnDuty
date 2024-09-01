package com.yusuf.data.remote

import com.yusuf.data.BuildConfig
import com.yusuf.data.remote.dto.city.CityRootDto
import com.yusuf.data.remote.dto.pharmacy.PharmacyRootDto
import retrofit2.http.GET
import retrofit2.http.Query


interface PharmacyApi {

    @GET("pharmacies-on-duty")
    suspend fun getPharmaciesOnDuty(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("city") city: String,
        @Query("district") district: String
    ): PharmacyRootDto

    @GET("pharmacies-on-duty/cities")
    suspend fun getCities(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("city") city: String? = null
    ): CityRootDto

}