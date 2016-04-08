package com.alvardev.visitcuritiba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alvardev.visitcuritiba.entities.PlaceEntity;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private CardView cvBotanicPark;
    private CardView cvOperaArame;
    private CardView cvPanoramicTower;
    private CardView cvMuseumOscarNiemeyer;
    private CardView cvTanguaPark;
    private CardView cvBacacheriPark;
    private CardView cvBariguiPark;

    private Toolbar toolbar;
    private List<PlaceEntity> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String name  = getIntent().getStringExtra("name");
        setUI();
        setWelcomeName(name);
        setToolbar();
        places = getPlaces();
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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setWelcomeName(String name){
        tvWelcome.append(" " + name);
    }

    private void setToolbar(){
        setSupportActionBar(toolbar);
    }

    private void setActions(){
        cvBotanicPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(places.get(0));
            }
        });

        cvOperaArame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(places.get(1));
            }
        });

        cvPanoramicTower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(places.get(2));
            }
        });

        cvMuseumOscarNiemeyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(places.get(3));
            }
        });

        cvTanguaPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(places.get(4));
            }
        });

        cvBacacheriPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(places.get(5));
            }
        });

        cvBariguiPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescription(places.get(6));
            }
        });
    }

    private void goToDescription(PlaceEntity place){
        Intent intent = new Intent(DashboardActivity.this, DescriptionActivity.class);
        intent.putExtra("place", place);
        startActivity(intent);
    }

    private List<PlaceEntity> getPlaces(){

        List<PlaceEntity> placesTemp = new ArrayList<>();
        PlaceEntity place = new PlaceEntity();

        //Jardim Botânico de Curitiba
        place.setName(getString(R.string.s_botanic_park));
        place.setAddress(getString(R.string.s_botanic_park_address));
        place.setIdImage(R.drawable.img_botanic_park_afternoon);
        place.setLat(-25.4430871);
        place.setLng(-49.2403687);
        placesTemp.add(place);

        //Ópera de Arame
        place = new PlaceEntity();
        place.setName(getString(R.string.s_opera_arame));
        place.setAddress(getString(R.string.s_opera_arame_address));
        place.setIdImage(R.drawable.img_opera_arame);
        place.setLat(-25.385076);
        place.setLng(-49.276626);
        placesTemp.add(place);

        //Torre Panorâmica
        place = new PlaceEntity();
        place.setName(getString(R.string.s_panoramic_tower));
        place.setAddress(getString(R.string.s_panoramic_tower_address));
        place.setIdImage(R.drawable.img_panoramic_tower);
        place.setLat(-25.424180);
        place.setLng(-49.294361);
        placesTemp.add(place);

        //Museu Oscar Niemeyer
        place = new PlaceEntity();
        place.setName(getString(R.string.s_museum_oscar_niemeyer));
        place.setAddress(getString(R.string.s_museum_oscar_niemeyer_address));
        place.setIdImage(R.drawable.img_museum_oscar_niemeyer);
        place.setLat(-25.410412);
        place.setLng(-49.266944);
        placesTemp.add(place);

        //Parque Tanguá
        place = new PlaceEntity();
        place.setName(getString(R.string.s_tangua_park));
        place.setAddress(getString(R.string.s_tangua_park_address));
        place.setIdImage(R.drawable.img_tangua_park);
        place.setLat(-25.378820);
        place.setLng(-49.281578);
        placesTemp.add(place);

        //Parque Bacacheri
        place = new PlaceEntity();
        place.setName(getString(R.string.s_bacacheri_park));
        place.setAddress(getString(R.string.s_bacacheri_park_address));
        place.setIdImage(R.drawable.img_bacacheri_park);
        place.setLat(-25.391102);
        place.setLng(-49.232866);
        placesTemp.add(place);

        //Parque Barigui
        place = new PlaceEntity();
        place.setName(getString(R.string.s_barigui_park));
        place.setAddress(getString(R.string.s_barigui_park_address));
        place.setIdImage(R.drawable.img_barigui_park);
        place.setLat(-25.423012);
        place.setLng(-49.308713);
        placesTemp.add(place);

        return placesTemp;
    }

}
