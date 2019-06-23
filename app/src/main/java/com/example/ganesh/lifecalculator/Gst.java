package com.example.ganesh.lifecalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Gst extends AppCompatActivity {
   EditText amount,percent;
   TextView finalamount,gstamount;
   Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gst);
        amount=(EditText)findViewById(R.id.editText_gst);
        percent=(EditText)findViewById(R.id.editText_gstpercent);
        finalamount=(TextView)findViewById(R.id.finalprice);
        gstamount=(TextView)findViewById(R.id.gstamount);
        cal=(Button)findViewById(R.id.gst_cal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(amount.getText().toString().isEmpty()|| percent.getText().toString().isEmpty()){
                   Toast.makeText(Gst.this,"Please check all the fields.",Toast.LENGTH_SHORT).show();
               }else{
                   double am=Double.parseDouble(amount.getText()+"");
                   double per=Double.parseDouble(percent.getText()+"");
                   double gstam=(am*(per/100));
                   double gst=am+gstam;
                   finalamount.setText(fmt(gst));
                   gstamount.setText(fmt(gstam));
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
