package com.example.randombeerdata

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.prayertime.model.PrayerTimesResponse
import com.example.randombeerdata.databinding.ActivityMainBinding
import com.example.randombeerdata.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)


        val latitude = "51.5194682"
        val longitude = "-0.1360365"
        val method = 3
        val school = 1
        val apiKey = "JZmSnlaJlm0XVHNRDeKogLUurUXiSmgmxVapl8ZMSDnafJpB"

        getPrayerTimes(latitude, longitude, method, school, apiKey)
    }
    private fun getPrayerTimes(lat: String, lon: String, method: Int, school: Int, apiKey: String) {
        RetrofitInstance.apiService.getPrayerTimes(lat, lon, method, school, apiKey)
            .enqueue(object : Callback<PrayerTimesResponse> {
                override fun onResponse(call: Call<PrayerTimesResponse>, response: Response<PrayerTimesResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()!!.data

                        val times = data.times
                        val qiblaDegrees = data.qibla.direction.degrees
                        val sunriseProhibited = data.prohibitedTimes.sunrise
                        val noonProhibited = data.prohibitedTimes.noon
                        val sunsetProhibited = data.prohibitedTimes.sunset

                        binding.fajrTime.text = " ${times.fajr}"
                        binding.sunriseTime.text = "${times.sunrise}"
                        binding.qiblaDirection.text = "${qiblaDegrees}°"

                        binding.sunriseProhibited.text = "সূর্যোদয়ের নিষিদ্ধ সময়: ${sunriseProhibited.start} - ${sunriseProhibited.end}"
                        binding.noonProhibited.text = "দুপুরের নিষিদ্ধ সময়: ${noonProhibited.start} - ${noonProhibited.end}"
                        binding.sunsetProhibited.text = "সূর্যাস্তের নিষিদ্ধ সময়: ${sunsetProhibited.start} - ${sunsetProhibited.end}"

                        binding.sunriseTime
                    } else {
                        Toast.makeText(applicationContext, "Failed to fetch prayer times", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<PrayerTimesResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}