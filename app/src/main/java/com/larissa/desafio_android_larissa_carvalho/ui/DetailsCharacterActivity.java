package com.larissa.desafio_android_larissa_carvalho.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


import com.larissa.desafio_android_larissa_carvalho.R;
import com.larissa.desafio_android_larissa_carvalho.databinding.ActivityDetailsCharacterBinding;
import com.larissa.desafio_android_larissa_carvalho.di.base.BaseApplication;
import com.larissa.desafio_android_larissa_carvalho.model.Character;
import com.larissa.desafio_android_larissa_carvalho.utils.Constants;
import com.larissa.desafio_android_larissa_carvalho.utils.Utils;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.DetailsCharacterViewModel;

import javax.inject.Inject;

public class DetailsCharacterActivity extends AppCompatActivity {

     private ActivityDetailsCharacterBinding detailsCharacterBinding;

     @Inject
     DetailsCharacterViewModel viewModel;

    private Utils util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsCharacterBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_character);
        util= new Utils();
        setUpDagger();
        startView();

    }

    private void setUpDagger(){
        ((BaseApplication)getApplication()).getRetrofitComponent().inject(this);
    }

    private void startView(){
        detailsCharacterBinding.setIsLoading(true);
        viewModel = new ViewModelProvider(this).get(DetailsCharacterViewModel.class);
        detailsCharacterBinding.imgBack.setOnClickListener(v -> onBackPressed());
        detailsCharacterBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ComicsHQActivity.class);
                String characterId = String.valueOf(getIntent().getIntExtra("id", 0));
                //Salva a o contexto em json no SharedPreferences
                SharedPreferences sharedPreferences =  getApplicationContext().getSharedPreferences("marvelId", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //id do pedido para ser a chave de acesso futuramente
                editor.putString("posicao.id", characterId);
                editor.apply();
                intent.putExtra("id", characterId);
                startActivity(intent);
            }
        });
        getDetailsCharacter();
    }

    private void getDetailsCharacter(){
        String characterId = String.valueOf(getIntent().getIntExtra("id", 0));
        viewModel.getDetailsCharacter(characterId, util.timestamp(), Constants.MARVEL_PUBLIC_KEY, util.md5())
                .observe(this, characterDetailsResponse -> {
                    detailsCharacterBinding.setIsLoading(false);
                    if (characterDetailsResponse.getData().getResults() != null){
                       int i = characterDetailsResponse.getData().getResults().size();
                       if(i == 1) {
                         loadCharacterDetails();
                       }else{
                           result();
                       }

                    }else{
                      alertApi();
                    }
                });
    }

    private void loadCharacterDetails() {
        detailsCharacterBinding.setName(getIntent().getStringExtra("name"));
        detailsCharacterBinding.setDescription(getIntent().getStringExtra("description"));
        detailsCharacterBinding.setImageURL(getIntent().getStringExtra("thumbnail"));
    }


    private void alertApi(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERRO");
        alertDialog.setMessage("Erro na listagem dos detalhes!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> onBackPressed());
        alertDialog.show();
    }

    private void result(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERRO");
        alertDialog.setMessage("Erro nos resultados dos detalhes!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> onBackPressed());
        alertDialog.show();
    }
}