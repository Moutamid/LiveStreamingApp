package com.moutamid.livestreamingapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Settings_Activity extends AppCompatActivity {

    TextView text1 , text2 , text3 , text4 , text5 , text6;
    Spinner test_spinner1 , test_spinner2 , test_spinner3 , test_spinner4 ,test_spinner6;

    String[] listItems1;
    String[] listItems2;
    String[] listItems3;
    String[] listItems4;
    String[] listItems6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text_2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);

        test_spinner1 = findViewById(R.id.test_spinner1);
        test_spinner2 = findViewById(R.id.test_spinner2);
        test_spinner3 = findViewById(R.id.test_spinner3);
        test_spinner4 = findViewById(R.id.test_spinner4);
        test_spinner6 = findViewById(R.id.test_spinner6);

        String myCurrent_dateTime = SimpleDateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        text5.setText(myCurrent_dateTime);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems1 = new String[]{
                        "English",
                        "French",
                        "German",
                        "Arabic",
                        "Deutsch",
                        "Turkish",
                };
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Settings_Activity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems1, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        text1.setText(listItems1[i]);
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems2 = new String[]{
                        "ON",
                        "OFF"};
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Settings_Activity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems2, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        text2.setText(listItems2[i]);
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems3 = new String[]{
                        "OFF",
                        "30 Minutes",
                        "1 Hour",
                        "1.5 Hour",
                        "2 Hour",
                        "2.5 Hour",
                        "3 Hour",
                };
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Settings_Activity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems3, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        text3.setText(listItems3[i]);
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems4 = new String[]{
                        "UTC+05:00, Asia",
                        "UTC+05:00, India",
                        "UTC+05:00, Australia",
                        "UTC+05:00, Hongkong",
                        "UTC+05:00, Singapore",
                        "UTC+05:00, Europe",
                        "UTC+05:00, Africa",
                };
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Settings_Activity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems4, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        text4.setText(listItems4[i]);
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems6 = new String[]{
                        "24-Hour",
                        "AM/PM"};
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Settings_Activity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems6, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        text6.setText(listItems6[i]);
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }
}