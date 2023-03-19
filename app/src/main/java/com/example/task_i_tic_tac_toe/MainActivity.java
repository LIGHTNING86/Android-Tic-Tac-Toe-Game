package com.example.task_i_tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    private LinearLayout playerOneLayout, playerTwoLayout;
    private TextView playerOneName, playerTwoName;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        playerOneLayout = findViewById(R.id.playerOneLayout);
        playerTwoLayout = findViewById(R.id.playerTwoLayout);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        combinationsList.add(new int[] {0, 1, 2});
        combinationsList.add(new int[] {3, 4, 5});
        combinationsList.add(new int[] {6, 7, 8});
        combinationsList.add(new int[] {0, 3, 6});
        combinationsList.add(new int[] {1, 4, 7});
        combinationsList.add(new int[] {2, 5, 8});
        combinationsList.add(new int[] {2, 4, 6});
        combinationsList.add(new int[] {0, 4, 8});

        final String getPlayerOneName = getIntent().getStringExtra("p1");
        final String getPlayerTwoName = getIntent().getStringExtra("p2");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        getSupportActionBar().hide();

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)) {
                    performAction((ImageView) view, 0);
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)) {
                    performAction((ImageView) view, 1);
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)) {
                    performAction((ImageView) view, 2);
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)) {
                    performAction((ImageView) view, 3);
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)) {
                    performAction((ImageView) view, 4);
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)) {
                    performAction((ImageView) view, 5);
                }
            }
        });

        image7. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)) {
                    performAction((ImageView) view, 6);
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)) {
                    performAction((ImageView) view, 7);
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)) {
                    performAction((ImageView) view, 8);
                }
            }
        });
    }

    private void performAction(ImageView imageview, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;

        if(playerTurn == 1) {
            imageview.setImageResource(R.drawable.cross_icon);

            if(checkPlayerWin()) {
                WinMessage winMessage = new WinMessage(MainActivity.this, playerOneName.getText().toString()+" has WON the Match!", MainActivity.this);
                winMessage.setCancelable(false);
                winMessage.show();
            }
            else if(totalSelectedBoxes == 9) {
                WinMessage winMessage = new WinMessage(MainActivity.this, "It is a DRAW!", MainActivity.this);
                winMessage.setCancelable(false);
                winMessage.show();
            }
            else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else {
            imageview.setImageResource(R.drawable.circle_icon);

            if(checkPlayerWin()) {
                WinMessage winMessage = new WinMessage(MainActivity.this, playerTwoName.getText().toString()+" has WON the Match!", MainActivity.this);
                winMessage.setCancelable(false);
                winMessage.show();
            }
            else if(selectedBoxPosition == 9) {
                WinMessage winMessage = new WinMessage(MainActivity.this, "It is a DRAW!", MainActivity.this);
                winMessage.setCancelable(false);
                winMessage.show();
            }
            else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;

        if(playerTurn == 1) {
            playerOneLayout.setBackgroundResource(R.drawable.round_bg_shape);
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_darkblue);
        }
        else {
            playerTwoLayout.setBackgroundResource(R.drawable.round_bg_shape);
            playerOneLayout.setBackgroundResource(R.drawable.round_back_darkblue);
        }
    }

    private boolean checkPlayerWin() {
        boolean response = false;

        for(int i = 0; i<combinationsList.size(); i++) {
            final int[] combinations = combinationsList.get(i);

            if(boxPositions[combinations[0]] == playerTurn && boxPositions[combinations[1]] == playerTurn && boxPositions[combinations[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }
    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;

        if(boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    public void restartMatch() {
        boxPositions = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn = 1;
        totalSelectedBoxes = 1;

        image1.setImageResource(R.drawable.transparent_bg);
        image2.setImageResource(R.drawable.transparent_bg);
        image3.setImageResource(R.drawable.transparent_bg);
        image4.setImageResource(R.drawable.transparent_bg);
        image5.setImageResource(R.drawable.transparent_bg);
        image6.setImageResource(R.drawable.transparent_bg);
        image7.setImageResource(R.drawable.transparent_bg);
        image8.setImageResource(R.drawable.transparent_bg);
        image9.setImageResource(R.drawable.transparent_bg);
    }
}