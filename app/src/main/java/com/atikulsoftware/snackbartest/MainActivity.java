package com.atikulsoftware.snackbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    RelativeLayout MotherLayout;
    Button simpleSnackbar, CustomSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MotherLayout = findViewById(R.id.MotherLayout);
        simpleSnackbar = findViewById(R.id.simpleSnackbar);
        CustomSnackbar = findViewById(R.id.CustomSnackbar);

        simpleSnackbar.setOnClickListener(v -> {
            // code here =========
            Snackbar.make(MotherLayout,"Subscribe my youtube channel", Snackbar.LENGTH_LONG)
                    .setAction("Subscribe", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Subscribed", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                    .show();
        });

        CustomSnackbar.setOnClickListener(v -> {
            // code here =========
            Snackbar snackbar = Snackbar.make(MotherLayout, "", Snackbar.LENGTH_LONG);
            View myView = getLayoutInflater().inflate(R.layout.custom_snackbar, null);
            snackbar.getView().setBackgroundColor(Color.TRANSPARENT);

            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
            snackbarLayout.setPadding(0,0,0,0);

            ImageView playBTN = myView.findViewById(R.id.playBTN);

            playBTN.setOnClickListener(v1 -> {
                playBTN.setImageResource(R.drawable.ic_stop);
            });

            snackbarLayout.addView(myView,0);
            snackbar.setDuration(10000);
            snackbar.show();

        });


    } // OnCreate Method Close Here ==============





} // Public Class ===========================