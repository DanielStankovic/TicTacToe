package com.example.daniel.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

public void showAboutGame(View view){

    Intent intent = new Intent(this, AboutGame.class);
            startActivity(intent);


}



    public void playGame(View view){

       Intent intent = new Intent(this, PlayGame.class);
        startActivity(intent);



        }






    }















