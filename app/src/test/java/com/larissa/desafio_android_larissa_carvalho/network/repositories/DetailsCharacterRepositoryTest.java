package com.larissa.desafio_android_larissa_carvalho.network.repositories;

import com.larissa.desafio_android_larissa_carvalho.network.ServiceAPI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DetailsCharacterRepositoryTest {

    @InjectMocks
    DetailsCharacterRepository detailsCharacterRepository = new DetailsCharacterRepository();
    ServiceAPI serviceAPI = detailsCharacterRepository.getService();


    @Test
    public void getServiceTest(){
        Assert.assertNotNull(detailsCharacterRepository);
        Assert.assertNotNull(serviceAPI);
    }
}