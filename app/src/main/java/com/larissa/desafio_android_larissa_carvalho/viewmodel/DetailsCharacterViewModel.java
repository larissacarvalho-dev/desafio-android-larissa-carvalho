package com.larissa.desafio_android_larissa_carvalho.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterDetailsResponse;
import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterResponse;
import com.larissa.desafio_android_larissa_carvalho.network.repositories.DetailsCharacterRepository;

import javax.inject.Inject;

public class DetailsCharacterViewModel extends ViewModel {

    private DetailsCharacterRepository detailsCharacterRepository;

    @Inject
    public DetailsCharacterViewModel(){
        detailsCharacterRepository = new DetailsCharacterRepository();
    }

    public LiveData<CharacterDetailsResponse> getDetailsCharacter(String characterId, long ts, String apiKey, String hash){
        return detailsCharacterRepository.getDetailsCharacter(characterId, ts, apiKey, hash);
    }
}
