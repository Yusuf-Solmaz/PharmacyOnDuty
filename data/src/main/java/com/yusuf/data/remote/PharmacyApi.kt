package com.yusuf.data.remote

import com.yusuf.data.BuildConfig
import com.yusuf.domain.model.pharmacy.PharmacyRootDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PharmacyApi {

    @GET("pharmacies-on-duty")
    suspend fun getPharmaciesOnDuty(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("city") city: String,
        @Query("district") district: String
    ): PharmacyRootDto

}