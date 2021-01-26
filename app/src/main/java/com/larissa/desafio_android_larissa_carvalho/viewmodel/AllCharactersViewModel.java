package com.larissa.desafio_android_larissa_carvalho.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterResponse;
import com.larissa.desafio_android_larissa_carvalho.network.repositories.AllCharactersRepository;

import javax.inject.Inject;

public class AllCharactersViewModel extends ViewModel {

    private AllCharactersRepository allCharactersRepository;

    @Inject
    public AllCharactersViewModel(){
        allCharactersRepository = new AllCharactersRepository();
    }

    public LiveData<CharacterResponse> getAllCharacters(int offset, int limit, long ts, String apiKey, String hash){
        return allCharactersRepository.getAllCharacters(offset, limit, ts, apiKey, hash);
    }
}
