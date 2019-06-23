package com.example.ganesh.lifecalculator;

import android.app.DatePickerDialog;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;


import com.jakewharton.threetenabp.AndroidThreeTen;

import java.util.Calendar;

public class Age extends AppCompatActivity   {
    public static final String TAG ="Age";
    private TextView displaydate_startdate,age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age);
        displaydate_startdate =(TextView) findViewById(R.id.startdate);
        Button btn=(Button) findViewById(R.id.age_cal);
        age=(TextView) findViewById(R.id.textView11);
        AndroidThreeTen.init(this.getApplication());
        displaydate_startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showdatepickerdialogue_start();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(displaydate_startdate.getText().toString().isEmpty()){
                    Toast.makeText(Age.this,"Please check all the fields.",Toast.LENGTH_SHORT).show();
                }else{
                    finddifference();

                }
            }
        });
    }
    private void showdatepickerdialogue_start(){

            DatePickerDialog dialog =new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                month+=1;
                String getdate=date+"/"+month+"/"+year;
                displaydate_startdate.setText(getdate);
            }

        },Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }



   public void finddifference(){
       String start=displaydate_startdate.getText()+"";
       SimpleDateFormat format= new SimpleDateFormat(("dd/MM/yyyy"));
       try {
           Date d1 = null;

           d1 = format.parse(start);

           Calendar c=Calendar.getInstance();
           c.setTime(d1);

           int year=c.get(Calendar.YEAR);
           int month=c.get(Calendar.MONTH)+1;
           int date=c.get(Calendar.DATE);



           org.threeten.bp.LocalDate yy =  org.threeten.bp.LocalDate.of(year, month, date);
           org.threeten.bp.LocalDate mm =  org.threeten.bp.LocalDate.now();
           org.threeten.bp.Period diff=org.threeten.bp.Period.between(yy,mm);

           age.setText(diff.getYears()+" Years   "+diff.getMonths()+" Months    "+diff.getDays()+" Days");
       }catch (Exception e){
           e.printStackTrace();
       }
   }
   }




