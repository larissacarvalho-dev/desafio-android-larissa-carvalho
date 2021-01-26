package com.larissa.desafio_android_larissa_carvalho.network.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterResponse;
import com.larissa.desafio_android_larissa_carvalho.network.ClientAPI;
import com.larissa.desafio_android_larissa_carvalho.network.ServiceAPI;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCharactersRepository {

    private ServiceAPI service;

    @Inject
    public AllCharactersRepository(){
        service = ClientAPI.getRetrofit().create(ServiceAPI.class);

    }

    public LiveData<CharacterResponse> getAllCharacters(int offset, int limit, long ts, String apiKey, String hash){
        MutableLiveData<CharacterResponse> data = new MutableLiveData<>();
        service.getAllCharacters(offset, limit, ts, apiKey, hash).enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public ServiceAPI getService() {
        return service;
    }
}
