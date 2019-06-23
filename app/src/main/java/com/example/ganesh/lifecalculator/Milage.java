package com.example.ganesh.lifecalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Milage extends AppCompatActivity {
    EditText premeter,currmeter,fuel,cost;
    Button btn;
    TextView milage,trlcost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milage);
        premeter=(EditText) findViewById(R.id.premeter);
        currmeter=(EditText) findViewById(R.id.curr_meter);
        fuel=(EditText) findViewById(R.id.fuel);
        cost=(EditText) findViewById(R.id.cost);
        btn=(Button) findViewById(R.id.milage_cal);
        milage=(TextView)findViewById(R.id.milage);
        trlcost=(TextView)findViewById(R.id.trvlcost);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(premeter.getText().toString().isEmpty()||currmeter.getText().toString().isEmpty()||fuel.getText().toString().isEmpty()||cost.getText().toString().isEmpty()){
                    Toast.makeText(Milage.this,"Please check all the fields",Toast.LENGTH_SHORT).show();
                }else {
                    float pr=Float.parseFloat(premeter.getText()+"");
                    float fu=Float.parseFloat(fuel.getText()+"");
                    float cu=Float.parseFloat(currmeter.getText()+"");
                    float cos=Float.parseFloat(cost.getText()+"");
                    float distance=cu-pr;
                    float mil=distance/fu;
                    float cost=cos/distance;
                    milage.setText(fmt((double)mil)+" kmpl");
                    trlcost.setText(fmt((double)cost)+" Rupees per km");
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
