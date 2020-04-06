package com.example.apiinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androdocs.httprequest.HttpRequest;
import com.appolica.flubber.Flubber;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    String users_api_key;
    EditText user_api;
    Button searchBtn;
    TextView country,state,city,zip_code,latitude,longitude,timezone,isp,organization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CALL ALL THE TEXTVIEW :

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);


        user_api = findViewById(R.id.user_api);
        searchBtn = findViewById(R.id.searchBtn);
        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        zip_code = findViewById(R.id.zip_code);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        timezone = findViewById(R.id.timezone);
        isp = findViewById(R.id.isp);
        organization = findViewById(R.id.organization);

        // ONCLICK EVENT :

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected() == true) {
                    users_api_key = user_api.getText().toString();
                    new ApiProcess().execute();
                }else{
                    Toast.makeText(MainActivity.this, "Check Your Internet Connection!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class ApiProcess extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String response = HttpRequest.excuteGet("http://ip-api.com/json/"+users_api_key);
            return response;
        }

        @Override
        protected void onPostExecute(String s) {

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_RIGHT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c1)                             // Apply it to the view
                    .start();
            c1.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_LEFT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c2)                             // Apply it to the view
                    .start();
            c2.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_RIGHT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c3)                             // Apply it to the view
                    .start();
            c3.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_LEFT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c4)                             // Apply it to the view
                    .start();
            c4.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_RIGHT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c5)                             // Apply it to the view
                    .start();
            c5.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_LEFT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c6)                             // Apply it to the view
                    .start();
            c6.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_RIGHT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c7)                             // Apply it to the view
                    .start();
            c7.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_LEFT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c8)                             // Apply it to the view
                    .start();
            c8.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.SQUEEZE_RIGHT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1200)                              // Last for 1000 milliseconds(1 second)
                    .createFor(c9)                             // Apply it to the view
                    .start();
            c9.setVisibility(View.VISIBLE);

            try {
                JSONObject jsonObject = new JSONObject(s);

                // GET ALL VALUES FROM API :
//                Log.d("test","-----------------------"+country_value);
                String country_value = jsonObject.getString("country");
                country.setText(country_value);
                String state_value = jsonObject.getString("regionName");
                state.setText(state_value);
                String city_value = jsonObject.getString("city");
                city.setText(city_value);
                String zip_code_value = jsonObject.getString("zip");
                zip_code.setText(zip_code_value);
                String latitude_value = jsonObject.getString("lat");
                latitude.setText(latitude_value);
                String longitude_value = jsonObject.getString("lon");
                longitude.setText(longitude_value);
                String time_zone_value = jsonObject.getString("timezone");
                timezone.setText(time_zone_value);
                String isp_value = jsonObject.getString("isp");
                isp.setText(isp_value);
                String organization_value = jsonObject.getString("org");
                organization.setText(organization_value);

            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, "Error :" + e.toString(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            super.onPostExecute(s);
        }

    }


}
