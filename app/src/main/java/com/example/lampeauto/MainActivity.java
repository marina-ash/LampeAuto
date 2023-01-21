package com.example.lampeauto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (toolbar);
        findViewById(R.id.toolbar);

        Button buttonGo = findViewById(R.id.buttonGo);
        buttonGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(myIntent);
            }
        });
    }

}