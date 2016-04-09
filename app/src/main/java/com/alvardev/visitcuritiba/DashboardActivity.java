package com.alvardev.visitcuritiba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alvardev.visitcuritiba.adapters.PlaceAdapter;
import com.alvardev.visitcuritiba.entities.PlaceEntity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements Response.Listener<String>,
        Response.ErrorListener{

    private static final String TAG = "DashboardActivity";
    private RecyclerView rvPlaces;
    private Toolbar toolbar;
    private TextView tviNoResults;
    private View progressBar;
    private List<PlaceEntity> places;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String name  = getIntent().getStringExtra("name");
        setUI();
        setToolbar(name);
        getPlaces();
        setRecyclerView();
    }

    private void setUI(){
        rvPlaces = (RecyclerView) findViewById(R.id.rv_places);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tviNoResults = (TextView) findViewById(R.id.tvi_no_results);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void setToolbar(String name){
        toolbar.setTitle(getString(R.string.s_welcome_message) + " " + name);
        setSupportActionBar(toolbar);
    }

    private void setRecyclerView(){
        rvPlaces.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvPlaces.setLayoutManager(mLayoutManager);

        PlaceAdapter mAdapter = new PlaceAdapter(places, DashboardActivity.this);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDescription(places.get(rvPlaces.getChildLayoutPosition(view)));
            }
        });

        rvPlaces.setAdapter(mAdapter);
        rvPlaces.setItemAnimator(new DefaultItemAnimator());
        rvPlaces.setVisibility(View.VISIBLE);
    }

    private void goToDescription(PlaceEntity place){
        Intent intent = new Intent(DashboardActivity.this, DescriptionActivity.class);
        intent.putExtra("place", place);
        startActivity(intent);
    }

    private void getPlaces(){
        places = new ArrayList<>();
        queue = Volley.newRequestQueue(this);
        progressBar.setVisibility(View.VISIBLE);

        String urlNotas = "https://raw.githubusercontent.com/AlvarDev/HostJson/master/places.js";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                urlNotas,
                this,
                this);
        stringRequest.setTag("places");
        queue.add(stringRequest);

    }


    @Override
    public void onResponse(String response) {
        progressBar.setVisibility(View.GONE);

        try {
            //if(!response.equalsIgnoreCase("EMPTY_COURSES")) {
            PlaceResponse rs = new Gson().fromJson(response, PlaceResponse.class);
            if(rs.isSuccess()){
                places = rs.getPlaces();
                setRecyclerView();
            }else{
                tviNoResults.setVisibility(View.VISIBLE);
            }

            //}else{
            //    tviNoResults.setVisibility(View.VISIBLE);
            //}
        }catch (Exception e){
            tviNoResults.setVisibility(View.VISIBLE);
            Log.e(TAG, "Error: " + e.getMessage());
        }
    }


    @Override
    public void onErrorResponse(VolleyError volleyError) {
        progressBar.setVisibility(View.GONE);
        tviNoResults.setText(getString(R.string.s_general_error_conexion));
        tviNoResults.setVisibility(View.VISIBLE);
        Log.e(TAG, "onErrorResponse: " + volleyError.getMessage());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (queue!=null){
            queue.cancelAll("places");
        }
    }


    private class PlaceResponse implements Serializable{

        private boolean success;
        private List<PlaceEntity> places;

        public boolean isSuccess() {
            return success;
        }

        public List<PlaceEntity> getPlaces() {
            return places;
        }

        @Override
        public String toString() {
            return "PlaceResponse{" +
                    "success=" + success +
                    ", places=" + places +
                    '}';
        }
    }


}
