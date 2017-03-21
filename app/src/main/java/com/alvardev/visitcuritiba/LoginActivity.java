package com.alvardev.visitcuritiba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.iid.FirebaseInstanceId;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText etName;
    private Button btnLetsGo;

    private Tracker mTracker;
    private String nameActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUI();
        setActions();
        Log.i(TAG, "Token FCM: " + FirebaseInstanceId.getInstance().getToken());
//        FirebaseCrash.report(new Exception("My first Android non-fatal error"));

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        nameActivity = "login";


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Setting screen name: " + nameActivity);
        mTracker.setScreenName(nameActivity);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    private void setUI(){
        etName = (EditText) findViewById(R.id.et_name);
        btnLetsGo = (Button) findViewById(R.id.btn_lets_go);
    }

    private void setActions(){
        btnLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //o que vai acontecer quando o usuário de click
                String name = etName.getText().toString();
                Log.i(TAG, "O nome é: " + name);

                if (validateName(name)) {
                    mTracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Action")
                            .setAction("login with: " + name)
                            .build());

                    goToDashboard(name);
                }

            }
        });
    }

    private boolean validateName(String name){
        etName.setError(null);

        if(name.isEmpty()){
            etName.setError(getString(R.string.s_name_empty));
            return false;
        }

        return true;

        //etName.setError(name.isEmpty() ? getString(R.string.s_name_empty) : null);
        //return name.isEmpty();
    }

    private void goToDashboard(String name){
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
