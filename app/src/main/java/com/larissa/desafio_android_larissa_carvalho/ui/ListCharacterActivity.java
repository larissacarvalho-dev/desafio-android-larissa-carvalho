package com.larissa.desafio_android_larissa_carvalho.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.larissa.desafio_android_larissa_carvalho.R;
import com.larissa.desafio_android_larissa_carvalho.databinding.ActivityMainBinding;
import com.larissa.desafio_android_larissa_carvalho.di.base.BaseApplication;
import com.larissa.desafio_android_larissa_carvalho.model.Character;
import com.larissa.desafio_android_larissa_carvalho.ui.adapters.CharacterAdapter;
import com.larissa.desafio_android_larissa_carvalho.ui.listeners.CharacterListener;
import com.larissa.desafio_android_larissa_carvalho.utils.Constants;
import com.larissa.desafio_android_larissa_carvalho.utils.Utils;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.AllCharactersViewModel;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ListCharacterActivity extends AppCompatActivity implements CharacterListener {

     @Inject
     AllCharactersViewModel viewModel;

     private List<Character> characterList = new ArrayList<Character>();

     private CharacterAdapter characterAdapter;

     private ActivityMainBinding activityMainBinding;

     private Utils util;

     private int currentPage = 0;

     private int totalPages = 1;

     private int limit= 20;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        util = new Utils();
        setUpDagger();
        startView();
    }

    private void setUpDagger(){
        ((BaseApplication)getApplication()).getRetrofitComponent().inject(this);
    }
    private void startView(){
        activityMainBinding.recyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider( this).get(AllCharactersViewModel.class);
        characterAdapter = new CharacterAdapter(characterList, this);
        activityMainBinding.recyclerView.setAdapter(characterAdapter);
        activityMainBinding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(!activityMainBinding.recyclerView.canScrollVertically(1)){
                    if (currentPage <= totalPages){
                        currentPage += 1;
                        getAllCharacter();
                    }
                }
            }
        });
        getAllCharacter();
    }


    private void getAllCharacter(){
        loadingStatus();
        viewModel.getAllCharacters(currentPage, limit, util.timestamp(), Constants.MARVEL_PUBLIC_KEY, util.md5()).observe( this, characterResponse ->{
            loadingStatus();
            if(characterResponse != null){
                totalPages= characterResponse.getData().getTotalPages();
                if (characterResponse.getData().getResults() != null){
                    int oldCount = characterList.size();
                    characterList.addAll(characterResponse.getData().getResults());
                    characterAdapter.notifyItemRangeInserted(oldCount, characterList.size());
                }else{
                    alertResult();
                }
            }else{
                alertApi();
            }
        });
    }

    private void loadingStatus(){
        if (currentPage == 0){
            if(activityMainBinding.getIsLoading() != null && activityMainBinding.getIsLoading()){
                activityMainBinding.setIsLoading(false);
            }else {
                activityMainBinding.setIsLoading(true);
            }

    }else{
            if (activityMainBinding.getIsLoadingMore() != null && activityMainBinding.getIsLoadingMore()){
                activityMainBinding.setIsLoadingMore(false);
            }else {
                activityMainBinding.setIsLoadingMore(true);
            }
        }
    }

    @Override
    public void onCharacterClicked(Character character) {
        Intent intent = new Intent(getApplicationContext(), DetailsCharacterActivity.class);
        intent.putExtra("id", character.getId());
        intent.putExtra("name", character.getName());
        intent.putExtra("description", character.getDescription());
        intent.putExtra("thumbnail", character.getThumbnail().getImage());

        SharedPreferences sharedPreferences =  getApplicationContext().getSharedPreferences("marvelId", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String thumb = character.getThumbnail().getImage();

        editor.putString("posicao.thumbnail", thumb);
        editor.apply();
        startActivity(intent);
    }

    private void alertApi(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERRO");
        alertDialog.setMessage("Erro na listagem dos personagens!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
        alertDialog.show();
    }

    private void alertResult(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERRO");
        alertDialog.setMessage("Erro na listagem dos resultados!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
        alertDialog.show();
    }
}