package com.larissa.desafio_android_larissa_carvalho.network;

import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterDetailsResponse;
import com.larissa.desafio_android_larissa_carvalho.model.responses.CharacterResponse;
import com.larissa.desafio_android_larissa_carvalho.model.responses.ComicResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceAPI {

    @GET("characters")
    Call<CharacterResponse> getAllCharacters(@Query("offset") int offset,
                                             @Query("limit") int limit,
                                             @Query("ts") long ts,
                                             @Query("apikey") String apikey,
                                             @Query("hash") String hash);


    @GET("characters/{characterId}")
    Call<CharacterDetailsResponse> getDetailsCharacter(@Path("characterId") String characterId,
                                                       @Query("ts") long ts,
                                                       @Query("apikey") String apikey,
                                                       @Query("hash") String hash);

    @GET("characters/{characterId}/comics")
    Call<ComicResponse> getComicsHQ(@Path("characterId") String characterId,
                                    @Query("ts") long ts,
                                    @Query("apikey") String apikey,
                                    @Query("hash") String hash);
}
