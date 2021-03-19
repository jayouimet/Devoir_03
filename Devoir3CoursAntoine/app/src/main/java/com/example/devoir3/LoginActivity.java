package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

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
        // On réfère l'UI au fichier logique
        this.loginButton = findViewById(R.id.loginButton);
        this.emailTextBox = findViewById(R.id.emailTextBox);
        this.passwordTextBox = findViewById(R.id.passwordTextBox);
        this.connectionErrorLabel = findViewById(R.id.connectionErrorLabel);
        this.connectionErrorLabel.setVisibility(View.GONE);
        this.forgotPasswordLabel = findViewById(R.id.forgotPasswordLabel);
        // On lie le texte forgot password à son activité
        this.setForgotPasswordLinkClickable();
        // On lie le bouton de connexion à son action
        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Si l'authentification est vraie, on passe à la prochaine vue, le cas échéant on affiche un message d'erreur
                if (auth()) {
                    Intent nextActivity = new Intent(LoginActivity.this, MesCours.class);
                    startActivity(nextActivity);
                }
                else {
                    connectionErrorLabel.setText(getResources().getString(R.string.wrong_email_password_combinaison_label));
                    connectionErrorLabel.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    /**
     * Logique d'authentification fake
     * */
    private boolean auth()
    {
        if (this.emailTextBox.getText().toString().equals("Test") && this.passwordTextBox.getText().toString().equals("1234")) {
            return true;
        }
        return false;
    }

    /**
     * Liaison du texte mot de passe oublié à sa logique
     * */
    private void setForgotPasswordLinkClickable()
    {
        SpannableString spannableString = new SpannableString(this.forgotPasswordLabel.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            // Lier ForgotPwdActivity au span
            public void onClick(View view) {
                Intent nextActivity = new Intent(LoginActivity.this, ForgotPwdActivity.class);
                startActivity(nextActivity);
            }

            // Changement du style du span
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getColor(R.color.main_light_blue));
            }
        };
        // Assignation de span au TextView
        spannableString.setSpan(clickableSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.forgotPasswordLabel.setText(spannableString);
        this.forgotPasswordLabel.setMovementMethod(LinkMovementMethod.getInstance());
    }
}