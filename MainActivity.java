package com.dicoding.picodiploma.nilaimahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inputAction(View v){
        Intent i = new Intent(MainActivity.this, InputActivity.class);
        startActivity(i);
    }

    public void lihatAction(View v){
        Intent i = new Intent(MainActivity.this, LihatActivity.class);
        startActivity(i);
    }

    public void exitAction(View v){
        System.exit(0);
    }

}
