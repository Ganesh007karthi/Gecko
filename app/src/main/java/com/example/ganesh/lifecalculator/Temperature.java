package com.example.ganesh.lifecalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Temperature extends AppCompatActivity {
    Spinner spinner,spinner2;
    Button cal;
    String temp[]={"C","F","K"};
    EditText t,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);
        spinner=(Spinner)findViewById(R.id.tempspin);
        spinner2=(Spinner)findViewById(R.id.tempspin2);
        Button cal=(Button)findViewById(R.id.temp_cal);
        t=(EditText)findViewById(R.id.editText_temp);
        t1=(EditText)findViewById(R.id.editText_temp2);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,temp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(t.getText().toString().isEmpty()){
                   Toast.makeText(Temperature.this,"Please check all the fields.",Toast.LENGTH_SHORT).show();
               }else{
                   String fr=spinner.getSelectedItem().toString();
                   String to=spinner2.getSelectedItem().toString();
                   double num=Double.parseDouble(t.getText()+"");
                   double num2=0.0d;
                   switch (fr){
                       case "C":
                       {
                           switch (to){
                               case "C":
                                   num2=num;
                                   break;
                               case "F":
                                   num2=num*1.8+32;
                                   break;
                               case "K":
                                   num2=num+273.15;
                                   break;
                           }
                           break;
                       }
                       case "F":
                       {
                           switch (to){
                               case "C":
                                   num2=(num-32)/1.8;
                                   break;
                               case "F":
                                   num2=num;
                                   break;
                               case "K":
                                   num2=(num + 459.67)* 5/9;
                                   break;
                           }
                           break;
                       }
                       case "K":
                       {
                           switch (to){
                               case "C":
                                   num2=num - 273.15;
                                   break;
                               case "F":
                                   num2=num*9/5 - 459.67;
                                   break;
                               case "K":
                                   num2=num;
                                   break;
                           }
                       }
                       break;
                   }
                   t1.setText(fmt(num2));
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
