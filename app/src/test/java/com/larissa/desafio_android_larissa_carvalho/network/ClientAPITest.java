package com.larissa.desafio_android_larissa_carvalho.network;

import com.larissa.desafio_android_larissa_carvalho.network.repositories.AllCharactersRepository;
import com.larissa.desafio_android_larissa_carvalho.utils.Constants;
import com.larissa.desafio_android_larissa_carvalho.utils.Utils;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import static com.larissa.desafio_android_larissa_carvalho.utils.Constants.BASE_URL;

public class ClientAPITest {

    @InjectMocks
    ClientAPI clientAPI = new ClientAPI();


    @Test
    public void getServiceTest(){
        Assert.assertNotNull(clientAPI);

    }

    @Test
    public void getBaseUrlTest(){
        Assert.assertEquals(BASE_URL, ClientAPI.getRetrofit().baseUrl().toString());
    }
}