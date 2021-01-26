package com.larissa.desafio_android_larissa_carvalho.di;

import com.larissa.desafio_android_larissa_carvalho.ui.ComicsHQActivity;
import com.larissa.desafio_android_larissa_carvalho.ui.DetailsCharacterActivity;
import com.larissa.desafio_android_larissa_carvalho.ui.ListCharacterActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = CharacterModule.class)
public interface CharacterComponent {
   void inject(ListCharacterActivity listCharacterActivity);
   void inject(DetailsCharacterActivity detailsCharacterActivity);
   void inject(ComicsHQActivity comicsHQActivity);
}
