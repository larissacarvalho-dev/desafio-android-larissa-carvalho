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
import com.larissa.desafio_android_larissa_carvalho.databinding.ActivityComicsHqBinding;
import com.larissa.desafio_android_larissa_carvalho.di.base.BaseApplication;
import com.larissa.desafio_android_larissa_carvalho.model.Character;
import com.larissa.desafio_android_larissa_carvalho.model.Comic;
import com.larissa.desafio_android_larissa_carvalho.utils.Constants;
import com.larissa.desafio_android_larissa_carvalho.utils.Utils;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.ComicsHQViewModel;
import com.larissa.desafio_android_larissa_carvalho.viewmodel.DetailsCharacterViewModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import okhttp3.internal.Util;

public class ComicsHQActivity extends AppCompatActivity {

    private List<Comic> comicList = new ArrayList<Comic>();

    private ActivityComicsHqBinding activityComicsHqBinding;

    private Utils util;

    @Inject
    ComicsHQViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComicsHqBinding = DataBindingUtil.setContentView(this, R.layout.activity_comics_hq);
        util = new Utils();
        setUpDagger();
        startView();
    }

    private void setUpDagger(){
        ((BaseApplication)getApplication()).getRetrofitComponent().inject(this);
    }

    private void startView(){
        activityComicsHqBinding.setIsLoading(true);

        viewModel = new ViewModelProvider(this).get(ComicsHQViewModel.class);

        activityComicsHqBinding.imgBack.setOnClickListener(v -> onBackPressed());
        activityComicsHqBinding.fab.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ListCharacterActivity.class);
            startActivity(intent);
        });
        getComicsHQ();
    }

    private void getComicsHQ(){
        String characterId = null;
        SharedPreferences sharedPreferences = getSharedPreferences("marvelId", Context.MODE_PRIVATE);

        //id do pedido para recuperar o json da nota
         characterId = sharedPreferences.getString("posicao.id", characterId);

        viewModel.getComicsHQ(characterId, util.timestamp(), Constants.MARVEL_PUBLIC_KEY, util.md5())
                .observe(this, comicResponse -> {
                    if (comicResponse.getData().getResults() != null){
                        List<Double> priceList = new ArrayList<>();
                        for (int i = 0; i < comicResponse.getData().getResults().size(); i++) {
                            for (int j = 0; j < comicResponse.getData().getResults().get(i).getPrices().size(); j++) {
                                priceList.add(comicResponse.getData().getResults().get(i).getPrices().get(j).getPrice());
                            }
                        }
                        if(priceList.size() != 0){
                            Double highestPrice = Collections.max(priceList);
                            int highestPriceIndex = priceList.indexOf(highestPrice);
                            activityComicsHqBinding.txtTitle.setText(comicResponse.getData().getResults().get(highestPriceIndex).getTitle());
                            activityComicsHqBinding.txtDescription.setText(comicResponse.getData().getResults().get(highestPriceIndex).getDescription());
                            activityComicsHqBinding.txtPrice.setText(DecimalFormat.getCurrencyInstance().format(highestPrice));
                            activityComicsHqBinding.setImgComic(comicResponse.getData().getResults().get(highestPriceIndex).getThumbnail().getImage());
                            loadCharacterDetails();
                        }else{
                            alertComics();
                        }
                    }else{
                        alertApi();
                    }
                });
    }

    private void loadCharacterDetails() {
        String thumb = null;
        SharedPreferences sharedPreferences = getSharedPreferences("marvelId", Context.MODE_PRIVATE);

        //id do pedido para recuperar o json da nota
        thumb = sharedPreferences.getString("posicao.thumbnail", thumb);
        activityComicsHqBinding.setIsLoading(false);
        activityComicsHqBinding.setImageURL(thumb);
    }

    private void alertComics(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Atenção");
        alertDialog.setMessage("Este personagem não tem HQ's");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> onBackPressed());
        alertDialog.show();
    }
    private void alertApi(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERRO");
        alertDialog.setMessage("Erro ao listar HQ!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
        alertDialog.show();
    }

}