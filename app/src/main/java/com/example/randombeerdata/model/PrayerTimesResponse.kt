package com.example.prayertime.model

import com.google.gson.annotations.SerializedName

data class PrayerTimesResponse(
    @SerializedName("code")
    val code: Int,

    @SerializedName("status")
    val status: String,

    @SerializedName("data")
    val data: Data
)

data class Data(
    @SerializedName("times")
    val times: Times,

    @SerializedName("date")
    val date: Date,

    @SerializedName("qibla")
    val qibla: Qibla,

    @SerializedName("prohibited_times")
    val prohibitedTimes: ProhibitedTimes
)

data class Times(
    @SerializedName("Fajr")
    val fajr: String,

    @SerializedName("Sunrise")
    val sunrise: String,

    @SerializedName("Dhuhr")
    val dhuhr: String,

    @SerializedName("Asr")
    val asr: String,

    @SerializedName("Sunset")
    val sunset: String,

    @SerializedName("Maghrib")
    val maghrib: String,

    @SerializedName("Isha")
    val isha: String,

    @SerializedName("Imsak")
    val imsak: String,

    @SerializedName("Midnight")
    val midnight: String,

    @SerializedName("Firstthird")
    val firstthird: String,

    @SerializedName("Lastthird")
    val lastthird: String
)

data class Date(
    @SerializedName("readable")
    val readable: String,

    @SerializedName("gregorian")
    val gregorian: Gregorian
)

data class Gregorian(
    @SerializedName("date")
    val date: String,

    @SerializedName("day")
    val day: String,

    @SerializedName("month")
    val month: Month,

    @SerializedName("year")
    val year: String
)

data class Month(
    @SerializedName("number")
    val number: Int,

    @SerializedName("en")
    val en: String
)

data class Qibla(
    @SerializedName("direction")
    val direction: Direction,

    @SerializedName("distance")
    val distance: Distance
)

data class Direction(
    @SerializedName("degrees")
    val degrees: Double
)

data class Distance(
    @SerializedName("value")
    val value: Double,

    @SerializedName("unit")
    val unit: String
)

data class ProhibitedTimes(
    @SerializedName("sunrise")
    val sunrise: TimeRange,

    @SerializedName("noon")
    val noon: TimeRange,

    @SerializedName("sunset")
    val sunset: TimeRange
)

data class TimeRange(
    @SerializedName("start")
    val start: String,

    @SerializedName("end")
    val end: String
)
