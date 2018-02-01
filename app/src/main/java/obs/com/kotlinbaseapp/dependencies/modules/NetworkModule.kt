package obs.com.kotlinbaseapp.dependencies.modules

import dagger.Module
import dagger.Provides
import obs.com.kotlinbaseapp.config.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * @author Created by vigneshwaran.n on 01-02-2018.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}