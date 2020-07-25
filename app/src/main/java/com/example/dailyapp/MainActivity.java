package com.example.dailyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        /*Stetho---------------------------------*/
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
            dbSetupInsert.insertAllCategory();
            dbSetupInsert.insertAllFood();
        }

        int numberUserRows = db.countRecord("users");
        if(numberUserRows < 1) {
            //Sign
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        }

        /*Close Database*/
        db.close();

    }
}