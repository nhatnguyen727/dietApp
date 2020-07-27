package com.example.dailyapp;

import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private String[] arraySpinnerDOBDay = new String[32];
    private String[] arraySpinnerDOBYear = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        /*Fill numbers for date of birth day */
        int human_counter = 0;
        for (int x = 0; x < 31; x++) {
            human_counter = x;
            this.arraySpinnerDOBDay[x] = "" + human_counter;
        }

        Spinner spinnerDOBDay = (Spinner) findViewById(R.id.spinnerDOBDay);
        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerDOBDay);
        spinnerDOBDay.setAdapter(adapterDay);

        /*Fill numbers for date of birth year */
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int end = year - 100;
        int index = 0;
        for (int x = year; x > end; x--) {
            this.arraySpinnerDOBYear[index] = "" + x;
            index++;
        }

        Spinner spinnerDOBYear = (Spinner) findViewById(R.id.spinnerDOBYear);
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerDOBYear);
        spinnerDOBYear.setAdapter(adapterYear);



        /*Hide error icon and message*/
        ImageView imageViewError = (ImageView) findViewById(R.id.imageViewError);
        imageViewError.setVisibility(View.GONE);
        TextView textViewErrorMessage = (TextView) findViewById(R.id.textViewErrorMessage);
        textViewErrorMessage.setVisibility(View.GONE);

        /*Hide inches field*/
        EditText editTextHeightInches = (EditText) findViewById(R.id.editTextInches);
        editTextHeightInches.setVisibility(View.GONE);

        /*Listener button measurement*/
        Spinner spinnerMeasurement = (Spinner) findViewById(R.id.spinnerMeasurement);
        spinnerMeasurement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                measurementChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //measurementChanged();
            }
        });
        /*Listener button signUp*/
        Button buttonSignUp = (Button) findViewById(R.id.buttonSubmit);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpSubmit();
            }
        });
    }

    /* Measurement Changed-------------------------*/
    public void measurementChanged() {
        Spinner spinnerMeasurement = (Spinner) findViewById(R.id.spinnerMeasurement);
        String stringMeasurement = spinnerMeasurement.getSelectedItem().toString();

        double heightCm = 0;
        double heightFeet = 0;
        double heightInches = 0;

        EditText editTextHeightCm = (EditText) findViewById(R.id.editTextHeight);
        EditText editTextHeightInches = (EditText) findViewById(R.id.editTextInches);
        String stringHeightCm = editTextHeightCm.getText().toString();
        String stringHeightInches = editTextHeightInches.getText().toString();

        TextView textViewCm = (TextView) findViewById(R.id.textViewCm);
        TextView textViewKg = (TextView) findViewById(R.id.textViewKg);


        if (stringMeasurement.startsWith("I")) {
            //Imperial
            editTextHeightInches.setVisibility(View.VISIBLE);
            textViewCm.setText("feet and inches");
            textViewKg.setText("pound");

            //find feet
            try {
                //convert Feet
                heightCm = Double.parseDouble(stringHeightCm);

            } catch (NumberFormatException nfe) {

            }
            if (heightCm != 0) {
                heightFeet = (heightCm * 0.3937008) / 12;
                int intHeightFeet = (int) heightFeet;
                editTextHeightCm.setText("" + intHeightFeet);
            }

        } else {
            //Metric

            editTextHeightInches.setVisibility(View.GONE);
            textViewCm.setText("cm");
            textViewKg.setText("Kg");

            //Change feet and inches to cm

            //Convert feet
            try {
                //convert Feet
                heightFeet = Double.parseDouble(stringHeightCm);

            } catch (NumberFormatException nfe) {

            }
            //convert inches
            try {
                heightInches = Double.parseDouble(stringHeightInches);

            } catch (NumberFormatException nfe) {
            }

            //Need to convert, we want to save the number in cm
            //cm= ((foot *12)+inches)*2.54
            if (heightFeet != 0 && heightInches != 0) {
                heightCm = ((heightFeet * 12) + heightInches) * 2.54;
                heightCm = Math.round(heightCm);
                editTextHeightCm.setText("" + heightCm);
            }
        }

        //Weight
        EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        String stringWeight = editTextWeight.getText().toString();
        double doubleWeight = 0;

        try {
            //convert Feet
            doubleWeight = Double.parseDouble(stringWeight);

        } catch (NumberFormatException nfe) {

        }
        if (doubleWeight != 0) {
            if (stringMeasurement.startsWith("I")) {
                //kg to pounds
                doubleWeight = Math.round(doubleWeight / 0.45359237);
            } else {
                doubleWeight = Math.round(doubleWeight * 0.45359237);
            }
            editTextWeight.setText("" + doubleWeight);
        }
    }

    /*Sign up Submit--------------------------------*/
    public void signUpSubmit() {
        //Error
        ImageView imageViewError = (ImageView) findViewById(R.id.imageViewError);
        TextView textViewErrorMessage = (TextView) findViewById(R.id.textViewErrorMessage);
        String errorMessage = "";

        //Email
        TextView textViewEmail = (TextView) findViewById(R.id.textViewEmail);

        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        String stringEmail = editTextEmail.getText().toString();
        if (stringEmail.isEmpty() || stringEmail.startsWith(" ")) {
            textViewEmail.setTextColor(Color.RED);
            errorMessage = "Please fill in an e-mail address";
        }

        //Date of birth Day
        Spinner spinnerDOBDay = (Spinner) findViewById(R.id.spinnerDOBDay);
        String stringDOBDay = spinnerDOBDay.getSelectedItem().toString();
        int intDOBDay = 0;
        try {
            intDOBDay = Integer.parseInt(stringDOBDay);
            if (intDOBDay < 10) {
                stringDOBDay = "0" + stringDOBDay;
            }
        } catch (NumberFormatException nfe) {
            errorMessage = "Please select a day for your birthday";
        }
        //month
        Spinner spinnerDOBMonth = (Spinner) findViewById(R.id.spinnerDOBMonth);
        String stringDOBMonth = spinnerDOBMonth.getSelectedItem().toString();
        if (stringDOBMonth.startsWith("Jan")) {
            stringDOBMonth = "01";
        } else if (stringDOBMonth.startsWith("Feb")) {
            stringDOBMonth = "02";
        } else if (stringDOBMonth.startsWith("Mar")) {
            stringDOBMonth = "03";
        } else if (stringDOBMonth.startsWith("Apr")) {
            stringDOBMonth = "04";
        } else if (stringDOBMonth.startsWith("May")) {
            stringDOBMonth = "05";
        } else if (stringDOBMonth.startsWith("Jun")) {
            stringDOBMonth = "06";
        } else if (stringDOBMonth.startsWith("Jul")) {
            stringDOBMonth = "07";
        } else if (stringDOBMonth.startsWith("Aug")) {
            stringDOBMonth = "08";
        } else if (stringDOBMonth.startsWith("Sep")) {
            stringDOBMonth = "09";
        } else if (stringDOBMonth.startsWith("Oct")) {
            stringDOBMonth = "10";
        } else if (stringDOBMonth.startsWith("Nov")) {
            stringDOBMonth = "11";
        } else if (stringDOBMonth.startsWith("Dec")) {
            stringDOBMonth = "12";
        }

        //Year
        Spinner spinnerDOBYear = (Spinner) findViewById(R.id.spinnerDOBYear);
        String stringDOBYear = spinnerDOBYear.getSelectedItem().toString();
        int intDOBYear = 0;
        try {
            intDOBYear = Integer.parseInt(stringDOBYear);
        } catch (NumberFormatException nfe) {
            errorMessage = "Please select a year for your birthday";
        }
        //put day of birth together
        String dateOfBirth = intDOBYear + "-" + stringDOBMonth + "-" + stringDOBDay;

        //gender
        RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        int radioButtonId = radioGroupGender.getCheckedRadioButtonId();
        View radioButtonGender = radioGroupGender.findViewById(radioButtonId);
        int position = radioGroupGender.indexOfChild(radioButtonGender);

        String stringGender = "";
        if (position == 0) {
            stringGender = "male";
        } else {
            stringGender = "female";
        }

        //Height
        EditText editTextHeightCm = (EditText) findViewById(R.id.editTextHeight);
        EditText editTextHeightInches = (EditText) findViewById(R.id.editTextInches);
        String stringHeightCm = editTextHeightCm.getText().toString();
        String stringHeightInches = editTextHeightInches.getText().toString();

        double heightCm = 0;
        double heightFeet = 0;
        double heightInches = 0;
        boolean metric = true;

        //Metric of imperial

        Spinner spinnerMeasurement = (Spinner) findViewById(R.id.spinnerMeasurement);
        String stringMeasurement = spinnerMeasurement.getSelectedItem().toString();

        int intMeasurement = spinnerMeasurement.getSelectedItemPosition();
        if (intMeasurement == 0) {
            stringMeasurement = "metric";
        } else {
            stringMeasurement = "imperial";
            metric = false;
        }

        if (metric == true) {
            try {
                //convert Cm
                heightCm = Double.parseDouble(stringHeightCm);

            } catch (NumberFormatException nfe) {
                errorMessage = "Height (cm) has to be a number";
            }
        } else {
            try {
                //convert Feet
                heightFeet = Double.parseDouble(stringHeightCm);

            } catch (NumberFormatException nfe) {
                errorMessage = "Height feet to be a number";
            }
            //convert inches
            try {
                heightInches = Double.parseDouble(stringHeightInches);

            } catch (NumberFormatException nfe) {
                errorMessage = "Height has to be a number";
            }
            //Need to convert, we want to save the number in cm
            //cm= ((foot *12)+inches)*2.54
            heightCm = ((heightFeet * 12) + heightInches) * 2.54;
            heightCm = Math.round(heightCm);
        }

        //Weight
        EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        String stringWeight = editTextWeight.getText().toString();
        double doubleWeight = 0;

        try {
            doubleWeight = Double.parseDouble(stringWeight);

        } catch (NumberFormatException nfe) {
            errorMessage = "Weight has to be a number";
        }
        if (metric == true) {

        } else {
            doubleWeight = Math.round(doubleWeight * 0.45359237);
        }


        //Activity Level
        Spinner spinnerActivityLevel = (Spinner) findViewById(R.id.spinnerActivity);
//     0-> little to no exercise
//    1->    Light exercise (1-3 days per week)
//    2->  Moderate exercise (3-5 days per week)</item>
//     3->   Heavy exercise (6-7 days per week)
//     4->   Very heavy exercise (twice per day,extra heavy workouts)
        int intActivityLevel = spinnerActivityLevel.getSelectedItemPosition();


        // Error handling
        if (errorMessage.isEmpty()) {
            //put data into database
            imageViewError.setVisibility(View.GONE);
            textViewErrorMessage.setVisibility(View.GONE);

            //insert in to database
            /* Database*/
            DBAdapter db = new DBAdapter(this);
            db.open();
            String stringEmailSQL = db.quoteSmart(stringEmail);
            String dateOfBirthSQL = db.quoteSmart(dateOfBirth);
            String stringGenderSQL = db.quoteSmart(stringGender);
            double heightCmSQL = db.quoteSmart(heightCm);
            int intActivityLevelSQL = db.quoteSmart(intActivityLevel);
            double doubleWeightSQL = db.quoteSmart(doubleWeight);
            String stringMeasurementSQL = db.quoteSmart(stringMeasurement);

            String stringInput = "NULL, " + stringEmailSQL + "," + dateOfBirthSQL + "," + stringGenderSQL + "," + heightCmSQL + "," + intActivityLevelSQL + "," + doubleWeightSQL + "," + stringMeasurementSQL;

            db.insert("users",
                    "user_id,user_email,user_dob,user_gender,user_height,user_activity_level,user_weight,user_measurement",
                    stringInput);
            db.close();
            //Move users back into main activity
            Intent intent = new Intent(SignUp.this,MainActivity.class);
            startActivity(intent);

        } else {
            //there is error
            textViewErrorMessage.setText(errorMessage);
            imageViewError.setVisibility(View.VISIBLE);
            textViewErrorMessage.setVisibility(View.VISIBLE);
        }
    }


}
