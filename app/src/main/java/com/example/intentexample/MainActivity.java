package com.example.intentexample;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button explicitButton = findViewById(R.id.explicitButton);
        explicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Explicit Intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button implicitButton = findViewById(R.id.implicitButton);
        implicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implicit Intent to open a web page
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://ritaj.birzeit.edu/"));
                startActivity(intent);
            }
        });

        Button startActivityForResultButton = findViewById(R.id.startActivityForResultButton);
        startActivityForResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start ThirdActivity for result
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                //Your task try to solve this problem
                //https://medium.com/@patelsneh18/startactvivityforresult-deprecated-alternative-and-using-it-outside-activity-class-bc9331cf896
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            TextView welcomeTextView = findViewById(R.id.welcomeTextView);
            welcomeTextView.setText("Welcome, " + name + "!");
        }
    }


    public void MakeCall(View view) {
        Intent intent = new Intent(MainActivity.this, CallActivity.class);

        // Start CallActivity
        startActivity(intent);
    }
}