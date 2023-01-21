package com.example.lampeauto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

public class toolbar extends AppCompatActivity {

    private toolbar Toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        setSupportActionBar(Toolbar); 
        findViewById(R.id.toolbar);
    }

    private void setSupportActionBar(toolbar toolbar) {
    }
}