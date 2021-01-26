package com.larissa.desafio_android_larissa_carvalho.network.repositories;

import com.larissa.desafio_android_larissa_carvalho.network.ServiceAPI;
import com.larissa.desafio_android_larissa_carvalho.utils.Constants;
import com.larissa.desafio_android_larissa_carvalho.utils.Utils;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.AllCharactersViewModel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.larissa.desafio_android_larissa_carvalho.utils.Constants.BASE_URL;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AllCharactersRepositoryTest {

    @InjectMocks
    AllCharactersRepository allCharactersRepository = new AllCharactersRepository();
    ServiceAPI serviceAPI = allCharactersRepository.getService();


    @Test
    public void getServiceTest(){
        Assert.assertNotNull(allCharactersRepository);
        Assert.assertNotNull(serviceAPI);
    }

}