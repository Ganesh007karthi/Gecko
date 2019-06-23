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

public class Percentage extends AppCompatActivity {
    EditText percent,of;
    Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percentage);
        percent = (EditText) findViewById(R.id.percent);
        of = (EditText) findViewById(R.id.of);
        final TextView isval = (TextView) findViewById(R.id.is);
        cal = (Button) findViewById(R.id.per_cal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(percent.getText().toString().isEmpty()||of.getText().toString().isEmpty()){
                    Toast.makeText(Percentage.this,"Please check all the fields.",Toast.LENGTH_SHORT).show();
                }else {
                    float per=Float.parseFloat(percent.getText()+"");
                    float ofval=Float.parseFloat(of.getText()+"");
                    float ans=0;
                    ans=(per/100)*ofval;
                    isval.setText(fmt((double)ans));
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
