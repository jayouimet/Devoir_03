package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgotPwdActivity extends AppCompatActivity {
    TextView forgotPasswordMessageSentLabel;
    Button forgotPasswordReinitialiseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        this.forgotPasswordReinitialiseButton = findViewById(R.id.forgotPasswordReinitialiseButton);
        this.forgotPasswordMessageSentLabel = findViewById(R.id.forgotPasswordMessageSentLabel);
        this.forgotPasswordMessageSentLabel.setVisibility(View.GONE);

        this.forgotPasswordReinitialiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPasswordMessageSentLabel.setText(getResources().getString(R.string.forgot_password_message_sent_label));
                forgotPasswordMessageSentLabel.setVisibility(View.VISIBLE);
            }
        });
    }
}