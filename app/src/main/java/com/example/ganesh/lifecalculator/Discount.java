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

public class Discount extends AppCompatActivity {
    EditText original,discount;
    TextView yousaved,total;
    Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount);
        original = (EditText) findViewById(R.id.orginal);
        discount = (EditText) findViewById(R.id.discount);
        total = (TextView) findViewById(R.id.finalval);
        cal = (Button) findViewById(R.id.dis_cal);
        yousaved=(TextView) findViewById(R.id.yousaved);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(original.getText().toString().isEmpty()||discount.getText().toString().isEmpty()){
                   Toast.makeText(Discount.this,"Please check all the field.", Toast.LENGTH_SHORT).show();
               }else{
                   float ori=Float.parseFloat(original.getText()+" ");
                   float dis=Float.parseFloat(discount.getText()+"");
                   float yousave=0;
                   yousave=ori*(dis/100);
                   float ans=ori-yousave;
                   total.setText(fmt((double)ans));
                   yousaved.setText(fmt((double)yousave));

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
