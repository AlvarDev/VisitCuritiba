package com.alvardev.visitcuritiba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvardev.visitcuritiba.entities.PlaceEntity;

public class DescriptionActivity extends AppCompatActivity {

    private ImageView ivPicture;
    private TextView tvName;
    private TextView tvAddress;
    private Button btMap;

    private Toolbar toolbar;
    private PlaceEntity place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        place = (PlaceEntity)getIntent().getSerializableExtra("place");
        setUI();
        setToolbar();
        setData(place);
        setActions();
    }

    private void setUI(){
        ivPicture = (ImageView) findViewById(R.id.iv_picture);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        btMap = (Button) findViewById(R.id.bt_map);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setToolbar(){
        setSupportActionBar(toolbar);
    }

    private void setData(PlaceEntity place){
        ivPicture.setImageResource(place.getIdImage());
        tvName.setText(place.getName());
        tvAddress.setText(place.getAddress());
    }

    private void setActions(){
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps(place);
            }
        });
    }

    private void goToMaps(PlaceEntity place){
        Intent intent = new Intent(DescriptionActivity.this, MapsActivity.class);
        intent.putExtra("place", place);
        startActivity(intent);
    }


}
