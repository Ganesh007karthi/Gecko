package com.example.ganesh.lifecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView bmicard,discard,percard,agecard,milagecard,tempcard,gstcard,weathercard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bmicard = (CardView)findViewById(R.id.c1);
       bmicard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              openbmi();
           }
       });

       discard = (CardView)findViewById(R.id.c2);
       discard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               opendiscount();
           }
       });

        percard= (CardView)findViewById(R.id.c3);
        percard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openpercentage();    }
        });

        agecard = (CardView)findViewById(R.id.c4);
        agecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openage();
            }
        });

        milagecard = (CardView)findViewById(R.id.c5);
        milagecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmilage();
            }
        });

        tempcard = (CardView)findViewById(R.id.c6);
        tempcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               opentemp();
            }
        });

        gstcard = (CardView)findViewById(R.id.c7);
        gstcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengst();
            }
        });

        weathercard = (CardView)findViewById(R.id.c8);
        weathercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openweather();
            }
        });

    }
    public void openbmi(){
        Intent intent= new Intent(this,Bmi.class);
        startActivity(intent);
    }
    public void opendiscount(){
        Intent intent= new Intent(this,Discount.class);
        startActivity(intent);
    }
    public void openpercentage(){
        Intent intent= new Intent(this,Percentage.class);
        startActivity(intent);
    }
    public void openage(){
        Intent intent= new Intent(this,Age.class);
        startActivity(intent);
    }
    public void openmilage(){
        Intent intent= new Intent(this,Milage.class);
        startActivity(intent);
    }
    public void opentemp(){
        Intent intent= new Intent(this,Temperature.class);
        startActivity(intent);
    }
    public void opengst(){
        Intent intent= new Intent(this,Gst.class);
        startActivity(intent);
    }
    public void openweather(){
        Intent intent= new Intent(this,Weather.class);
        startActivity(intent);
    }


}
