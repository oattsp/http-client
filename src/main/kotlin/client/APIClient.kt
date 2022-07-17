package client

import constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    private lateinit var instance: Retrofit

    fun getRetrofit(): Retrofit {
        if (!this::instance.isInitialized) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance
    }
}