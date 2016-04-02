package com.alvardev.visitcuritiba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    private ImageView ivPicture;
    private TextView tvName;
    private TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        int id  = getIntent().getIntExtra("id", R.id.cv_botanic_park);
        setUI();
        setData(id);
    }

    private void setUI(){
        ivPicture = (ImageView) findViewById(R.id.iv_picture);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvAddress = (TextView) findViewById(R.id.tv_address);
    }

    private void setData(int id){

        int imageId = 0;
        String name = "";
        String address = "";

        switch (id){
            case R.id.cv_botanic_park:
                imageId = R.drawable.img_botanic_park_afternoon;
                name = getString(R.string.s_botanic_park);
                address = getString(R.string.s_botanic_park_address);
                break;
            case R.id.cv_opera_arame:
                imageId = R.drawable.img_opera_arame;
                name = getString(R.string.s_opera_arame);
                address = getString(R.string.s_opera_arame_address);
                break;
            case R.id.cv_panoramic_tower:
                imageId = R.drawable.img_panoramic_tower;
                name = getString(R.string.s_panoramic_tower);
                address = getString(R.string.s_panoramic_tower_address);
                break;
            case R.id.cv_museum_oscar_niemeyer:
                imageId = R.drawable.img_museum_oscar_niemeyer;
                name = getString(R.string.s_museum_oscar_niemeyer);
                address = getString(R.string.s_museum_oscar_niemeyer_address);
                break;
            case R.id.cv_tangua_park:
                imageId = R.drawable.img_tangua_park;
                name = getString(R.string.s_tangua_park);
                address = getString(R.string.s_tangua_park_address);
                break;
            case R.id.cv_bacacheri_park:
                imageId = R.drawable.img_bacacheri_park;
                name = getString(R.string.s_bacacheri_park);
                address = getString(R.string.s_bacacheri_park_address);
                break;
            case R.id.cv_barigui_park:
                imageId = R.drawable.img_barigui_park;
                name = getString(R.string.s_barigui_park);
                address = getString(R.string.s_barigui_park_address);
                break;
        }

        ivPicture.setImageResource(imageId);
        tvName.setText(name);
        tvAddress.setText(address);

    }

}
