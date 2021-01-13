package com.example.tictactoe_app_baazi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Here, 0 is indicating 'X', 1 is indicating 'O', 2 is indicating empty space in that position in the grid
    int curr_player = 0;
    boolean gameStatus = true;
    int [] currGrid = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winCases = {{0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};

    public void tapping(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        boolean isDraw = true;
        for (int i=0 ; i<currGrid.length ; i++)
        {
            if (currGrid[i] == 2)
            {
                isDraw = false;
                break;
            }
        }

        if(!gameStatus || isDraw) {
            newGame(view);
        }
        if(currGrid[tappedImage] == 2) {
            currGrid[tappedImage] = curr_player;
            img.setTranslationY(-1000f);
            if (curr_player == 0) {
                img.setImageResource(R.drawable.x);
                curr_player = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Baazi's Turn - Make Your Move");
            } else {
                img.setImageResource(R.drawable.o);
                curr_player = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Baba's Turn - Make Your Move");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        // Checking for the winning condition
        for(int[] winCase: winCases){
            if(currGrid[winCase[0]] == currGrid[winCase[1]] && currGrid[winCase[1]] == currGrid[winCase[2]]
                    && currGrid[winCase[0]]!=2)
            {

                String msgToPrint;
                gameStatus = false;
                if(currGrid[winCase[0]] == 0){
                    msgToPrint = "Baba has won";
                }
                else{
                    msgToPrint = "Baazi has won";
                }

                TextView status = findViewById(R.id.status);
                status.setText(msgToPrint);

            }
        }
    }

    public void newGame(View view) {
        gameStatus = true;
        curr_player = 0;

        for(int i=0; i<currGrid.length; i++) currGrid[i] = 2;

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("Baazi's Turn - Make Your Move");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}