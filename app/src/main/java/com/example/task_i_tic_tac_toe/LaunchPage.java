package com.example.task_i_tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchPage extends AppCompatActivity {
    TextView t1,t2,t3;
    ImageView img1;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);

        img1 = (ImageView) findViewById(R.id.game_logo);
        t1 = (TextView) findViewById(R.id.tic);
        t2 = (TextView) findViewById(R.id.tac);
        t3 = (TextView) findViewById(R.id.toe);

        t1.setTranslationY(300);
        t2.setTranslationY(300);
        t3.setTranslationY(300);
        img1.setTranslationY(300);

        t1.setAlpha(v);
        t2.setAlpha(v);
        t3.setAlpha(v);
        img1.setAlpha(v);

        img1.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        t1.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        t2.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        t3.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();

        getSupportActionBar().hide();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchPage.this,AddPlayers.class));
                finish();
            }
        },5000);
    }
}
