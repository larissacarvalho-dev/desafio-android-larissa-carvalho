package com.larissa.desafio_android_larissa_carvalho.network.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterDetailsResponse;
import com.larissa.desafio_android_larissa_carvalho.model.responses.ComicResponse;
import com.larissa.desafio_android_larissa_carvalho.network.ClientAPI;
import com.larissa.desafio_android_larissa_carvalho.network.ServiceAPI;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicsHQRepository {

    private ServiceAPI service;

    @Inject
    public ComicsHQRepository() {
        service = ClientAPI.getRetrofit().create(ServiceAPI.class);
    }


    public LiveData<ComicResponse> getComicsHQ(String characterId, long ts, String apiKey, String hash){
        MutableLiveData<ComicResponse> data = new MutableLiveData<>();
        service.getComicsHQ(characterId, ts, apiKey, hash).enqueue(new Callback<ComicResponse>() {
            @Override
            public void onResponse(Call<ComicResponse> call, Response<ComicResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ComicResponse> call, Throwable t) {
                Log.e("ERRO: " , t.getMessage());
            }
        });
        return data;
    }

    public ServiceAPI getService() {
        return service;
    }
}
