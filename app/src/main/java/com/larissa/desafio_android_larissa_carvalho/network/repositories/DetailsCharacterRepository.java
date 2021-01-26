package com.larissa.desafio_android_larissa_carvalho.network.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterDetailsResponse;
import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterResponse;
import com.larissa.desafio_android_larissa_carvalho.network.ClientAPI;
import com.larissa.desafio_android_larissa_carvalho.network.ServiceAPI;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsCharacterRepository {

    private ServiceAPI service;

    @Inject
    public DetailsCharacterRepository() {
        service = ClientAPI.getRetrofit().create(ServiceAPI.class);
    }


    public LiveData<CharacterDetailsResponse> getDetailsCharacter(String characterId, long ts, String apiKey, String hash){
        MutableLiveData<CharacterDetailsResponse> data = new MutableLiveData<>();
        service.getDetailsCharacter(characterId, ts, apiKey, hash).enqueue(new Callback<CharacterDetailsResponse>() {
            @Override
            public void onResponse(Call<CharacterDetailsResponse> call, Response<CharacterDetailsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CharacterDetailsResponse> call, Throwable t) {
                Log.e("ERRO: " , t.getMessage());
            }
        });
        return data;
    }

    public ServiceAPI getService() {
        return service;
    }
}
