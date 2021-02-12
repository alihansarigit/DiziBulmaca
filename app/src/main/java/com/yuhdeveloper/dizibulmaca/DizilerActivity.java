package com.yuhdeveloper.dizibulmaca;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdView;
import com.onesignal.OneSignal;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class DizilerActivity extends AppCompatActivity {

    List<String> lstSeriesName;
    RecyclerView recyclerView;
    List<Integer> lstSeriesImage;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diziler);

        toolbar = findViewById(R.id.myToolbar);
        toolbar.inflateMenu(R.menu.my_menu);

        SharedPreferences sharedPreferences = getSharedPreferences("point", MODE_PRIVATE);
        int previousPoint = sharedPreferences.getInt("point", 0);
        toolbar.getMenu().getItem(1).setTitle(String.valueOf(previousPoint));

        Fabric.with(this, new Crashlytics());

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        lstSeriesImage = new ArrayList<>();
        lstSeriesName = new ArrayList<>();
        recyclerView = findViewById(R.id.diziler_Recy);

        DataPool dataPool = new DataPool();
        lstSeriesImage = dataPool.getLstImage();
        lstSeriesName = dataPool.getLstName();

        RecyAdapter recyAdapter = new RecyAdapter(getApplicationContext(),lstSeriesName,lstSeriesImage);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyAdapter);

    }
}
