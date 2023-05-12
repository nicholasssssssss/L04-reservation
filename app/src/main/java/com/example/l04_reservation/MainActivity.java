package com.example.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    DatePicker datePicker;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    Button submitbtn;
    Button resetbtn;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker=findViewById(R.id.timepickers);
        datePicker=findViewById(R.id.datepickers);
        editText1=findViewById(R.id.etname);
        editText2=findViewById(R.id.etnum);
        editText3=findViewById(R.id.etnumofppl);
        submitbtn=findViewById(R.id.submitbtn);
        resetbtn=findViewById(R.id.resetbtn);
        radioGroup=findViewById(R.id.preferedTable);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numPerson = Integer.parseInt(editText3.getText().toString());
                int checkedRadioId = radioGroup.getCheckedRadioButtonId();
                int year=datePicker.getYear();
                int month=datePicker.getMonth() + 1;
                int day= datePicker.getDayOfMonth();
                int hour=timePicker.getCurrentHour();
                int min=timePicker.getCurrentMinute();


                if(numPerson > 0 ){
                    Toast.makeText(getApplicationContext(), "Booked table for " + numPerson, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Number of people", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Reservation Date is "+day+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Reservation Time is" +hour+" : "+min, Toast.LENGTH_SHORT).show();
                if (checkedRadioId == R.id.smokingTable){
                    Toast.makeText(getApplicationContext(), "Reserved for Smoking Table", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Reserved for Non-Smoking Table", Toast.LENGTH_SHORT).show();
                }
            }
        });


        resetbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timePicker.setCurrentHour(0);
                    timePicker.setCurrentMinute(0);
                    datePicker.updateDate(2020,0,1);
                    editText1.setText("");
                    editText2.getText().clear();
                    editText3.getText().clear();
            }
        });
    }
}