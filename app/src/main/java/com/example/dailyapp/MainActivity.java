package com.example.dailyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Sletho---------------------------------*/
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        /* Database*/
        DBAdapter db = new DBAdapter(this);
        db.open();

        /* Set up for food*/
        //Count rows in food
        int numberRows = db.countRecord("food");

        if(numberRows<1){
            DBSetupInsert dbSetupInsert = new DBSetupInsert(this);
            dbSetupInsert.insertAllFood();
            dbSetupInsert.insertAllCategory();
        }

        /*Close Database*/
        db.close();


        Toast.makeText(this, "Database work, food create", Toast.LENGTH_SHORT).show();
    }
}