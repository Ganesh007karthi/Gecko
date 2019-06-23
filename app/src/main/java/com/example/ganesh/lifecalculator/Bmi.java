package com.example.ganesh.lifecalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi extends AppCompatActivity {
    Button button;
    EditText height,weight;
    TextView bmi;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText) findViewById(R.id.weight);
        bmi=(TextView)findViewById(R.id.bmi);
        image=(ImageView)findViewById(R.id.info);
        button=(Button)findViewById(R.id.button);
        int imageresourse = getResources().getIdentifier("@drawable/bmiinfo",null,this.getPackageName());
        image.setImageResource(imageresourse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()){
                    Toast.makeText(Bmi.this, "Please check all the fields.", Toast.LENGTH_SHORT).show();
                }else {
                    float h= Float.parseFloat(height.getText()+"");
                    float w=Float.parseFloat(weight.getText()+"");
                    float denom=h*h;
                    float ans=w/denom;
                    ans=ans*10000;

                    bmi.setText(fmt((double)ans));
                }
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

    }
    public String fmt(double d){
        if(d==Math.floor(d)){
            return String.format("%.0f",d);
        }else{
            return Double.toString(d);
        }
    }



}

