package com.yuhdeveloper.dizibulmaca;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    int placeHolder;
    ArrayList<Integer> drawables;


    ArrayList<Integer> drawableList;
    ArrayList<ImageView> imgList;

    TextView txt_dogru, txt_yanlis, txt_geriSayim, txt_starPoint;
    int pointSuccess = 0;
    int pointError = 0;
    int value = 0;
    AdView bannerView;
    FrameLayout frameLayout;

    int geriSayim = 61000;
    CountDownTimer geriSayimSayici;
    int previousPoint = 0;

    int imageResourceNumber = 0;
    ArrayList<Integer> lstdrawables;
    CountDownTimer timer;

    AdRequest adRequest;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adRequest = new AdRequest.Builder()
                .addTestDevice("D9A8CF2E36EF152A1BA0456397164FF4")
                .build();

        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                adView.loadAd(adRequest);
//                Toast.makeText(MainActivity.this, "a" + i, Toast.LENGTH_SHORT).show();
            }
        });
        adView.loadAd(adRequest);
        FrameLayout.LayoutParams frameLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        frameLayout = new FrameLayout(this);

        frameLayout.setLayoutParams(frameLayoutParams);
        bannerView = new AdView(MainActivity.this);
        bannerView.setAdSize(AdSize.SMART_BANNER);
        bannerView.setAdUnitId("ca-app-pub-2516048937640163/1809357345");
        bannerView.loadAd(adRequest);

        frameLayout.addView(bannerView);

        txt_dogru = findViewById(R.id.txt_dogru);
        txt_yanlis = findViewById(R.id.txt_yanlis);
        txt_geriSayim = findViewById(R.id.txt_gerisayim);
        txt_starPoint = findViewById(R.id.txt_starPoint);

        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txt_geriSayim.setText("Kalan Süre : " + geriSayim / 1000);
        drawableList = new ArrayList<>();
        imgList = new ArrayList<>();

        linearLayout = findViewById(R.id.main_lnrBase);


        value = getIntent().getExtras().getInt("chooseSeries");
        drawables = new DataPool().getDrawable(value);
        placeHolder = new DataPool().getPlaceHolder(value);
        setHorizontalItem(drawables, linearLayout);
        lstdrawables = shakeList(drawables);
        linearLayout.addView(frameLayout);

        SharedPreferences sharedPreferences = getSharedPreferences("point", MODE_PRIVATE);
        previousPoint = sharedPreferences.getInt("point", 0);
        txt_starPoint.setText(String.valueOf(previousPoint));

    }


    @Override
    protected void onDestroy() {
        if (geriSayimSayici != null) {
            geriSayimSayici.cancel();
        }


        super.onDestroy();
    }

    ImageView getImage(int jk) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150, 150);

        ImageView imageView = new ImageView(this);
        imageView.setOnClickListener(this);
        imageView.setLayoutParams(lp);
        imageView.setPadding(15, 0, 0, 0);
        Picasso.get().load(placeHolder).fit().into(imageView);
        imageView.setId(jk);
        return imageView;
    }

    LinearLayout getLayoutHorizontal() {

        LinearLayout lnrHorizontal = new LinearLayout(this);
        lnrHorizontal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        lnrHorizontal.setOrientation(LinearLayout.HORIZONTAL);
        lnrHorizontal.setPadding(50, 5, 50, 5);

        return lnrHorizontal;
    }
    int size;
    void setHorizontalItem(ArrayList<Integer> lstdrawables, LinearLayout lnrVerti) {

        size = lstdrawables.size();
        int jk = 0;

        for (int i = 0; i < size / 4; i++) {
            LinearLayout lnrHorizontal = getLayoutHorizontal();
            for (int k = 0; k < 4; k++) {
                ImageView img_1 = getImage(jk);
                lnrHorizontal.addView(img_1);
                jk++;
            }
            lnrVerti.addView(lnrHorizontal);
        }
        lnrVerti.addView(adView);


        geriSayimSayici = new CountDownTimer(geriSayim, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txt_geriSayim.setText("Kalan Süre : " + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {
                txt_geriSayim.setText("Kalan Süre : 0");
                gameOver();
                Toast.makeText(MainActivity.this, "Oyun Bitti", Toast.LENGTH_SHORT).show();
            }
        }.start();

    }


    @Override
    public void onClick(View v) {

        if (drawableList.size() < 2) {
            ImageView img = (ImageView) v; // tıkladıgım resim
            imgList.add(img);// tekrar eski haline döndürmek için listeye alıyorum
            drawableList.add(lstdrawables.get(v.getId())); // tıkladıgım resmin , resmi

            Picasso.get().load(drawableList.get(drawableList.size() - 1)).fit().into(img);

            if (imgList.size() == 2) {
                if (imgList.get(0).getId() == imgList.get(1).getId()) {
                    imgList.remove(imgList.size() - 1);
                    drawableList.remove((drawableList.size() - 1));
                }
            }
        } else {

            reImage(imgList);
            imgList.clear();
            drawableList.clear();
            imageResourceNumber = 0;
            if (timer != null) {
                timer.cancel();
            }

            ImageView img = (ImageView) v; // tıkladıgım resim
            imgList.add(img);// tekrar eski haline döndürmek için listeye alıyorum
            drawableList.add(lstdrawables.get(v.getId())); // tıkladıgım resmin , resmi
            Picasso.get().load(drawableList.get(drawableList.size() - 1)).fit().into(img);
        }

        if (drawableList.size() > 1) {
            if (imgList.get(0).getId() != imgList.get(1).getId()) {
                System.out.println("cikti=> " + drawableList.get(0) + " " + drawableList.get(1));
                if (drawableList.get(0).equals(drawableList.get(1))) {
                    pointUp();
                    imgList.get(0).setVisibility(View.INVISIBLE);
                    imgList.get(1).setVisibility(View.INVISIBLE);
                    imgList.clear();
                    drawableList.clear();
                    imageResourceNumber = 0;
                    size=size-2;
                    if (size==0) {
                        gameOver();
                    }
                } else {
                    pointDown();
                    timer = new CountDownTimer(2000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            reImage(imgList);
                            imgList.clear();
                            drawableList.clear();
                            imageResourceNumber = 0;
                        }
                    }.start();
                }
            }

        } else {
        }
    }

    void pointUp() {
        pointSuccess += 1;
        txt_dogru.setText("Doğru : " + pointSuccess);
    }

    void pointDown() {
        pointError += 1;
        txt_yanlis.setText("Yanlış : " + pointError);

    }

    void reImage(ArrayList<ImageView> _id) {
        for (int i = 0; i < _id.size(); i++) {
            Picasso.get().load(placeHolder).fit().into(_id.get(i));
        }
    }

    ArrayList<Integer> shakeList(ArrayList<Integer> _lstDrawable) {
        ArrayList<Integer> shakeList = new ArrayList<>();
        int r;
        int size = _lstDrawable.size();
        for (int i = 0; i < size; i++) {
            r = new Random().nextInt(_lstDrawable.size());
            shakeList.add(_lstDrawable.get(r));
            _lstDrawable.remove(r);
            System.out.println("shake it => " + shakeList.get(i));
        }
        return shakeList;
    }

    void gameOver() {

        int point = previousPoint + (pointSuccess*2 - pointError);
        if (previousPoint > -1 && point > previousPoint) {
            SharedPreferences sharedPreferences = getSharedPreferences("point", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("point", point);
            editor.commit();
        }

        Intent intent = new Intent(MainActivity.this, DizilerActivity.class);
        startActivity(intent);

    }


}
