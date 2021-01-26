package com.larissa.desafio_android_larissa_carvalho.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ImageView;

import com.larissa.desafio_android_larissa_carvalho.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import static android.provider.Settings.System.getString;

public class Utils {

    public long timestamp(){
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        date = new java.sql.Timestamp(c.getTime().getTime());

        long dateInMillis = date.getTime()/1000;

        return dateInMillis;
    }

    public String md5(){

        long date = timestamp();

        String s = date + Constants.MARVEL_PRIVATE_KEY + Constants.MARVEL_PUBLIC_KEY;
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(s.getBytes(),0,s.length());

        String md5 = new BigInteger(1,m.digest()).toString(16);

        System.out.println("TIMESTAMP: "+date + " MD5: " + md5);

        return md5;
    }
}
