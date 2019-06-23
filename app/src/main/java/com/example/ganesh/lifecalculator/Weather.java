package com.example.ganesh.lifecalculator;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class Weather extends AppCompatActivity {
    TextView temp,press,hum,wind,des,txtLocation;
    EditText city;
    Button go;
    final int REQUEST_CODE = 1234;
    final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";

    final String API_KEY = "9bb27cc5d7471d761429db2c2ccf671f";




    // Create Instance of LocationManager and LocationListener


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        temp=(TextView)findViewById(R.id.fintemp);
        press=(TextView)findViewById(R.id.finpress);
        hum=(TextView)findViewById(R.id.finhum);
        txtLocation=(TextView)findViewById(R.id.fincity);
        wind=(TextView)findViewById(R.id.finwind);
        des=(TextView)findViewById(R.id.findes);
        go=(Button)findViewById(R.id.gobtn);
        city=(EditText)findViewById(R.id.edtemp);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(city.getText().toString().isEmpty()){
                    Toast.makeText(Weather.this,"Please check all the fields.",Toast.LENGTH_SHORT).show();
                }else {
                    String cityname=city.getText().toString();
                    getNewCityWeather(cityname);
                }
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

    }

    private void getNewCityWeather(String cityName) {

        RequestParams requestParams = new RequestParams();

        requestParams.put("q", cityName);
        requestParams.put("appid", API_KEY);

        apiCall(requestParams);
    }



    private void apiCall(RequestParams requestParams) {


            AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

            asyncHttpClient.get(WEATHER_URL, requestParams, new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    super.onSuccess(statusCode, headers, response);

                    Weather1 weather = Weather1.fromJson(response);
                    updateWeatherDetails(weather);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);

                    Toast.makeText(Weather.this, "Error occurred while making request!", Toast.LENGTH_LONG).show();
                }
            });


    }
    private void updateWeatherDetails(Weather1 weather) {

        temp.setText(weather.getTemperature());
        wind.setText(weather.getWind());
        hum.setText(weather.getHumidity());
        press.setText(weather.getPressure());
        des.setText(weather.getDescription());
        txtLocation.setText(weather.getCity() + ", " + weather.getCountry());

    }


}
