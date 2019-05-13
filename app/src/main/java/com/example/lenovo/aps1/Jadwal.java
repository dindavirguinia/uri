package com.example.lenovo.aps1;

import android.app.AlarmManager;

import android.app.PendingIntent;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import android.widget.TimePicker;

import android.widget.Toast;


import java.util.Calendar;




public class Jadwal extends AppCompatActivity implements View.OnClickListener{



    private int notificationId = 1;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

// Set Onclick Listener.
        Button aturBtn = (Button) findViewById(R.id.setBtn);
        Button tolakBtn = (Button) findViewById(R.id.cancelBtn);

        findViewById(R.id.setBtn).setOnClickListener(this);

        findViewById(R.id.cancelBtn).setOnClickListener(this);

    }

    @Override

    public void onClick(View view) {

        EditText editText = findViewById(R.id.inputdata);

        //TimePicker timePicker = findViewById(R.id.pilihwaktu);

        DatePicker datePicker = findViewById(R.id.pilihwaktu);


// Set notificationId & text.

        Intent intent = new Intent(Jadwal.this, AlarmReceiver.class);

        intent.putExtra("notificationId", notificationId);

        intent.putExtra("todo", editText.getText().toString());



// getBroadcast(context, requestCode, intent, flags)


        PendingIntent alarmIntent = PendingIntent.getBroadcast(Jadwal.this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);


        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);



        switch (view.getId()) {

            case R.id.setBtn:

                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int dayofmonth = datePicker.getDayOfMonth();

               // int hour = timePicker.getCurrentHour();

                //int minute = timePicker.getCurrentMinute();




// Create time.

                Calendar startTime = Calendar.getInstance();

                startTime.set(Calendar.YEAR, year);

                startTime.set(Calendar.MONTH, month);

                startTime.set(Calendar.DAY_OF_MONTH, dayofmonth);

                long alarmStartTime = startTime.getTimeInMillis();



// Set alarm.

// set(type, milliseconds, intent)

                alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);



                Toast.makeText(this, "Jadwal Tersimpan!", Toast.LENGTH_SHORT).show();

                break;



            case R.id.cancelBtn:

                alarm.cancel(alarmIntent);

                Toast.makeText(this, "Dibatalkan", Toast.LENGTH_SHORT).show();

                break;

        }


    }
}
