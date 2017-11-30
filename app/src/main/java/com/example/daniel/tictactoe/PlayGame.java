package com.example.daniel.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class PlayGame extends AppCompatActivity {

    ImageView image0;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;


    ImageView[] buttons = {image0,image1, image2, image3, image4, image5, image6, image7, image8};
    ArrayList<ImageView> fields = new ArrayList<>();

    ArrayList<ImageView> available = new ArrayList<>();

    String[] sign = new String[9];

    TextView winnerText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);




        buttons[0]= (ImageView)findViewById(R.id.image_0);
        buttons[1]= (ImageView)findViewById(R.id.image_1);
        buttons[2]= (ImageView)findViewById(R.id.image_2);
        buttons[3]= (ImageView)findViewById(R.id.image_3);
        buttons[4]= (ImageView)findViewById(R.id.image_4);
        buttons[5]= (ImageView)findViewById(R.id.image_5);
        buttons[6]= (ImageView)findViewById(R.id.image_6);
        buttons[7]= (ImageView)findViewById(R.id.image_7);
        buttons[8]= (ImageView)findViewById(R.id.image_8);
        for(int i = 0; i<buttons.length; i++){
            available.add(buttons[i]);
        }

        }





        public void onClick(View view){
            String fieldID = this.getResources().getResourceName(view.getId());
            int index = Integer.parseInt(fieldID.split("_")[1]);
            if(!fields.contains(available.get(index))) {
               available.get(index).setImageResource(R.drawable.x_sign);
               fields.add(available.get(index));
                sign[index] = "x";
              checkWinner();

    }


            else
                return;
            calculateAI();
            }


    public void calculateAI() {
        if (fields.size() < 9) {
            Random random = new Random();
            int AIindex = random.nextInt(9);
            if (!fields.contains(available.get(AIindex))) {
                available.get(AIindex).setImageResource(R.drawable.o_sign);
                fields.add(available.get(AIindex));
                sign[AIindex] = "o";
                checkWinner();


            }
            else
                calculateAI();

        }
        else if(fields.size() == 9)
            tieResult();

    }




    public void checkWinner(){

       if(sign[0] == "x" && sign[1] == "x" && sign[2] == "x"  ){
           playerWon();

       }
       else if(sign[0] == "o" && sign[1] == "o" && sign[2] == "o"  ){
           androidWon();
       }


       else if(sign[0] == "x" && sign[3] == "x" && sign[6] == "x"  ){
           playerWon();
       }
       else if(sign[0] == "o" && sign[3] == "o" && sign[6] == "o"  ){
           androidWon();
        }


       else if (sign[6] == "x" && sign[7] == "x" && sign[8] == "x" ){
           playerWon();
       }
       else if (sign[6] == "o" && sign[7] == "o" && sign[8] == "o" ){
           androidWon();
       }


       else if (sign[2] == "x" && sign[5] == "x" && sign[8] == "x" ){
           playerWon();
       }
       else if (sign[2] == "o" && sign[5] == "o" && sign[8] == "o" ){
           androidWon();
       }


       else if (sign[3] == "x" && sign[4] == "x" && sign[5] == "x" ){
           playerWon();
       }
       else if (sign[3] == "o" && sign[4] == "o" && sign[5] == "o" ){
           androidWon();
       }


       else if (sign[1] == "x" && sign[4] == "x" && sign[7] == "x" ){
           playerWon();
       }
       else if (sign[1] == "o" && sign[4] == "o" && sign[7] == "o" ){
           androidWon();
       }


       else if (sign[0] == "x" && sign[4] == "x" && sign[8] == "x" ){
           playerWon();
       }
       else if (sign[0] == "o" && sign[4] == "o" && sign[8] == "o" ){
           androidWon();
       }


       else if (sign[2] == "x" && sign[4] == "x" && sign[6] == "x" ){
           playerWon();
       }
       else if (sign[2] == "o" && sign[4] == "o" && sign[6] == "o" ){
           androidWon();
       }



    }

    public void restartGame(View view) {

        recreate();
    }

    public void playerWon(){
        setContentView(R.layout.winner);
        winnerText = (TextView)findViewById(R.id.winnerText);
        winnerText.setText("Player wins!");


    }

    public void androidWon(){
        setContentView(R.layout.winner);
        winnerText = (TextView)findViewById(R.id.winnerText);
        winnerText.setText("Android wins!");


    }
    public void tieResult(){
        setContentView(R.layout.winner);
        winnerText = (TextView)findViewById(R.id.winnerText);
        winnerText.setText("It is a tie!");


    }
    }

