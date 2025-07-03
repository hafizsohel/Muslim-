package com.example.randombeerdata.service

import com.example.prayertime.model.PrayerTimesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimeService {

    @GET("api/v1/prayer-time/")
    fun getPrayerTimes(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("method") method: Int,
        @Query("school") school: Int,
        @Query("api_key") apiKey: String
    ): Call<PrayerTimesResponse>
}
