package com.larissa.desafio_android_larissa_carvalho.di;

import com.larissa.desafio_android_larissa_carvalho.network.ServiceAPI;
import com.larissa.desafio_android_larissa_carvalho.utils.Constants;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.AllCharactersViewModel;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.ComicsHQViewModel;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.DetailsCharacterViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.larissa.desafio_android_larissa_carvalho.utils.Constants.BASE_URL;

@Module
public class CharacterModule {

    @Singleton
    @Provides
    GsonConverterFactory provideGsonFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Singleton
    @Provides
    OkHttpClient provideOkClient (HttpLoggingInterceptor loggingInterceptor){
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory){
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
    }

    @Singleton
    @Provides
    AllCharactersViewModel provideMainActivityViewModel(){
        return new AllCharactersViewModel();
    }

    @Singleton
    @Provides
    DetailsCharacterViewModel provideDetailsCharacterViewModel(){
        return new DetailsCharacterViewModel();
    }

    @Singleton
    @Provides
    ComicsHQViewModel provideComicsHQViewModel(){
        return new ComicsHQViewModel();
    }

    @Singleton
    @Provides
    ServiceAPI provideApiPeople(Retrofit retrofit){
        return retrofit.create(ServiceAPI.class);
    }
}
