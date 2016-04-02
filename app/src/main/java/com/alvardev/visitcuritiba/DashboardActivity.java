package com.alvardev.visitcuritiba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private CardView cvBotanicPark;
    private CardView cvOperaArame;
    private CardView cvPanoramicTower;
    private CardView cvMuseumOscarNiemeyer;
    private CardView cvTanguaPark;
    private CardView cvBacacheriPark;
    private CardView cvBariguiPark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String name  = getIntent().getStringExtra("name");
        setUI();
        setWelcomeName(name);
        setActions();
    }

    private void setUI(){
        tvWelcome = (TextView) findViewById(R.id.tv_welcome);

        cvBotanicPark = (CardView) findViewById(R.id.cv_botanic_park);
        cvOperaArame = (CardView) findViewById(R.id.cv_opera_arame);
        cvPanoramicTower = (CardView) findViewById(R.id.cv_panoramic_tower);
        cvMuseumOscarNiemeyer = (CardView) findViewById(R.id.cv_museum_oscar_niemeyer);
        cvTanguaPark = (CardView) findViewById(R.id.cv_tangua_park);
        cvBacacheriPark = (CardView) findViewById(R.id.cv_bacacheri_park);
        cvBariguiPark = (CardView) findViewById(R.id.cv_barigui_park);
    }

    private void setWelcomeName(String name){
        tvWelcome.append(" " + name);
    }

    private void setActions(){
        cvBotanicPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(R.id.cv_botanic_park);
            }
        });

        cvOperaArame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(R.id.cv_opera_arame);
            }
        });

        cvPanoramicTower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(R.id.cv_panoramic_tower);
            }
        });

        cvMuseumOscarNiemeyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(R.id.cv_museum_oscar_niemeyer);
            }
        });

        cvTanguaPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(R.id.cv_tangua_park);
            }
        });

        cvBacacheriPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(R.id.cv_bacacheri_park);
            }
        });

        cvBariguiPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(R.id.cv_barigui_park);
            }
        });
    }

    private void goToDescription(int id){
        Intent intent = new Intent(DashboardActivity.this, DescriptionActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
