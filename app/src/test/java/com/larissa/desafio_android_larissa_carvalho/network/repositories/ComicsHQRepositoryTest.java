package com.larissa.desafio_android_larissa_carvalho.network.repositories;

import com.larissa.desafio_android_larissa_carvalho.network.ServiceAPI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ComicsHQRepositoryTest {

    @InjectMocks
    ComicsHQRepository comicsHQRepository = new ComicsHQRepository();
    ServiceAPI serviceAPI = comicsHQRepository.getService();


    @Test
    public void getServiceTest(){
        Assert.assertNotNull(comicsHQRepository);
        Assert.assertNotNull(serviceAPI);
    }

}