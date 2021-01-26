package com.larissa.desafio_android_larissa_carvalho.ui.adapters;

import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class BindingAdapters {

    @androidx.databinding.BindingAdapter("android:imageURL")
    public static void setImageURL(ImageView imageView, String URL){
        try{
            imageView.setAlpha(0f);
            Picasso.get().load(URL).noFade().into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    imageView.animate().setDuration(300).alpha(1f).start();
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    Log.e("Erro: ", e.getMessage());
                }
            });

        }catch (Exception e){
            e.printStackTrace();
            Log.e("Erro: ", e.getMessage());
        }
    }
}
