package com.larissa.desafio_android_larissa_carvalho.di.base;

import android.app.Application;

import com.larissa.desafio_android_larissa_carvalho.di.CharacterComponent;
import com.larissa.desafio_android_larissa_carvalho.di.CharacterModule;
import com.larissa.desafio_android_larissa_carvalho.di.DaggerCharacterComponent;

public class BaseApplication extends Application {

    private CharacterComponent characterComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        characterComponent = DaggerCharacterComponent
                .builder()
                .characterModule(new CharacterModule())
                .build();
    }

    public CharacterComponent getRetrofitComponent(){
        return characterComponent;
    }

}
