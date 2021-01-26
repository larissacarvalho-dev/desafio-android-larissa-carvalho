package com.larissa.desafio_android_larissa_carvalho.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.larissa.desafio_android_larissa_carvalho.R;


public class SplashScreen extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView imgSplash;
    TextView  txtSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        imgSplash = findViewById(R.id.imgSplash);
        txtSplash = findViewById(R.id.txtSplash);

        imgSplash.setAnimation(topAnim);
        txtSplash.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, ListCharacterActivity.class);
                startActivity(intent);
                finish();
            }
        } , 2000);

    }
}