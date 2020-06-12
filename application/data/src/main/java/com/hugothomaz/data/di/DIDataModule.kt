package com.hugothomaz.data.di

import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hugothomaz.data.BuildConfig
import com.hugothomaz.data.cloud.AppCloud
import com.hugothomaz.data.cloud.GEOApi
import com.hugothomaz.data.cloud.FreightAPI
import com.hugothomaz.data.local.DB_NAME
import com.hugothomaz.data.local.FreightLocal
import com.hugothomaz.data.local.RotaFreteDatabase
import com.hugothomaz.data.repository.FreightRepository
import com.hugothomaz.domain.repository.IFreightRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {

    //RotaFreteDatabase
    single {
        Room.databaseBuilder(
            get(), RotaFreteDatabase::class.java,
            DB_NAME
        )
            .build()
    }

    // DAOs
    single {
        get<RotaFreteDatabase>().freightDao()
    }

    // Local
    single {
        FreightLocal(dao = get())
    }

    single { provideGson() }

    single { provideOkHttpCliente() }

    single { provideRxJavaCallAdapterFactory() }

    single { provideConverterFactory(get<Gson>()) }


    factory(named("geo")) { provideRetrofit(BuildConfig.BASE_URL_GEO, get<OkHttpClient>(), get<GsonConverterFactory>(), get<RxJava2CallAdapterFactory>()) }

    factory(named("freight")) { provideRetrofit(BuildConfig.BASE_URL_FREIGHT, get<OkHttpClient>(), get<GsonConverterFactory>(), get<RxJava2CallAdapterFactory>()) }

    single { providerServiceGEOApi(get(named("geo"))) }

    single { providerServiceFreightAPI(get(named("freight"))) }

    single { AppCloud(get<GEOApi>(), get<FreightAPI>()) }

    single<IFreightRepository> { FreightRepository(appCloud =  get(), local = get()) }

}


fun provideGson(): Gson {
    return GsonBuilder()
        .create()
}


fun provideOkHttpCliente(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}


fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
    return RxJava2CallAdapterFactory.create()
}


fun provideConverterFactory(gson: Gson): GsonConverterFactory {
    return GsonConverterFactory.create(gson)
}


fun provideRetrofit(url : String,
    client: OkHttpClient,
    converterFactory: GsonConverterFactory,
    adapterFactory: RxJava2CallAdapterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(adapterFactory)
        .client(client)
        .build()
}


fun providerServiceGEOApi(retrofit: Retrofit): GEOApi {
    return retrofit.create(GEOApi::class.java)
}

fun providerServiceFreightAPI(retrofit: Retrofit): FreightAPI {
    return retrofit.create(FreightAPI::class.java)
}


