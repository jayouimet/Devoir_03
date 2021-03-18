package com.example.devoir3;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class NotificationInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_info);

        TextView tv1 = (TextView)findViewById(R.id.info);
        TextView tv2 = (TextView)findViewById(R.id.titre);
        TextView tv3 = (TextView)findViewById(R.id.sigle);
        Bundle b = getIntent().getExtras();
        tv2.setText(b.getString("title"));
        tv1.setText(b.getString("info"));
        tv3.setText(b.getString("sigle"));
    }
}