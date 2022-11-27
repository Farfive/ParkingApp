package com.example.parking.di

import android.app.Application
import androidx.room.Room
import com.example.parking.data.ParkingSpotDatabase
import com.example.parking.data.ParkingSpotRepositoryImpl
import com.example.parking.domain.repository.ParkingSpotRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@dagger.Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingSpotDatabase {
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parking_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDatabase): ParkingSpotRepositoryImpl {
        return ParkingSpotRepositoryImpl(db.dao)
    }
}