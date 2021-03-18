package com.example.devoir03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private TextInputEditText emailTextBox;
    private TextInputEditText passwordTextBox;
    private TextView connectionErrorLabel;

    private TextView forgotPasswordLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginButton = findViewById(R.id.loginButton);
        this.emailTextBox = findViewById(R.id.emailTextBox);
        this.passwordTextBox = findViewById(R.id.passwordTextBox);
        this.connectionErrorLabel = findViewById(R.id.connectionErrorLabel);
        this.connectionErrorLabel.setVisibility(View.GONE);
        this.forgotPasswordLabel = findViewById(R.id.forgotPasswordLabel);

        this.setForgotPasswordLinkClickable();

        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auth()) {
                    // TODO : Change to next activity, uncomment and change NEXT_ACTIVITY with the next activity name
                    // Intent nextActivity = new Intent(LoginActivity.this, NEXT_ACTIVITY.class);
                    // startActivity(nextActivity);
                    Intent nextActivity = new Intent(LoginActivity.this, CalendarActivity.class);
                    startActivity(nextActivity);
                }
                else {
                    connectionErrorLabel.setText(getResources().getString(R.string.wrong_email_password_combinaison_label));
                    connectionErrorLabel.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private boolean auth()
    {
        if (this.emailTextBox.getText().toString().equals("Test") && this.passwordTextBox.getText().toString().equals("1234")) {
            return true;
        }
        return false;
    }

    private void setForgotPasswordLinkClickable()
    {
        SpannableString spannableString = new SpannableString(this.forgotPasswordLabel.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(LoginActivity.this, ForgotPwdActivity.class);
                startActivity(nextActivity);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getColor(R.color.main_light_blue));

            }
        };
        spannableString.setSpan(clickableSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.forgotPasswordLabel.setText(spannableString);
        this.forgotPasswordLabel.setMovementMethod(LinkMovementMethod.getInstance());
    }
}