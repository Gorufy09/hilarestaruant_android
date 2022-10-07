package com.example.hillarestaurantcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class app_menu extends AppCompatActivity {

    private Button btnback;
    private ImageButton btn_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(app_menu.this,MainActivity.class));
                finish();
            }
        });

        btn_profile = (ImageButton) findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(app_menu.this,My_Profile.class));
                finish();
            }
        });
    }
}