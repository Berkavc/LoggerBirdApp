package utils

import loggerbird.LoggerBird
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class is used for creating retrofit client for basecamp.
 */
internal class RetrofitUserBasecampClient {
    companion object {
        /**
         * This method is used for creating client in order to use in retrofit builder.
         */
       internal fun getBasecampUserClient(url:String): Retrofit {
            val client = OkHttpClient.Builder()
                .addInterceptor(
                    BasicAuthBasecampInterceptor()
                )
                .build()
            return Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}