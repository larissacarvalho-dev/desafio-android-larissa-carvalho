package com.larissa.desafio_android_larissa_carvalho.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterDetailsResponse;
import com.larissa.desafio_android_larissa_carvalho.model.responses.ComicResponse;
import com.larissa.desafio_android_larissa_carvalho.network.repositories.ComicsHQRepository;
import com.larissa.desafio_android_larissa_carvalho.network.repositories.DetailsCharacterRepository;

import javax.inject.Inject;

public class ComicsHQViewModel extends ViewModel {

    private ComicsHQRepository comicsHQRepository;

    @Inject
    public ComicsHQViewModel(){
        comicsHQRepository = new ComicsHQRepository();
    }

    public LiveData<ComicResponse> getComicsHQ(String characterId, long ts, String apiKey, String hash){
        return comicsHQRepository.getComicsHQ(characterId, ts, apiKey, hash);
    }
}
