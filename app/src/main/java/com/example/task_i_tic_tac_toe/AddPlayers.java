package com.example.task_i_tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddPlayers extends AppCompatActivity {
    TextView t1;
    LinearLayout l1,l2;
    EditText p1,p2;
    Button start;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_players);

        t1 = (TextView) findViewById(R.id.enter_text);
        l1 = (LinearLayout) findViewById(R.id.player_one);
        l2 = (LinearLayout) findViewById(R.id.player_two);
        start = (Button) findViewById(R.id.start_btn);
        p1 = (EditText) findViewById(R.id.playerOne);
        p2 = (EditText) findViewById(R.id.playerTwo);

        t1.setTranslationY(300);
        l1.setTranslationY(300);
        l2.setTranslationY(300);
        start.setTranslationY(300);

        t1.setAlpha(v);
        l1.setAlpha(v);
        l2.setAlpha(v);
        start.setAlpha(v);

        t1.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        l1.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        l2.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        start.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();

        getSupportActionBar().hide();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getPlayerOneName = p1.getText().toString();
                final String getPlayerTwoName = p2.getText().toString();

                if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                    Toast.makeText(AddPlayers.this, "Please Enter Player Names in the required Fields...", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("p1", getPlayerOneName);
                    intent.putExtra("p2", getPlayerTwoName);
                    startActivity(intent);
                }
            }
        });
    }
}
