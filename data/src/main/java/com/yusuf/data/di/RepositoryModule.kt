package com.yusuf.data.di

import com.yusuf.data.remote.PharmacyApi
import com.yusuf.data.repository.CityRepositoryImpl
import com.yusuf.data.repository.PharmacyRepositoryImpl
import com.yusuf.domain.repository.city.CityRepository
import com.yusuf.domain.repository.pharmacy.PharmacyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePharmacyRepository(api: PharmacyApi): PharmacyRepository {
        return PharmacyRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCityRepository(api: PharmacyApi): CityRepository {
        return CityRepositoryImpl(api)
    }


}