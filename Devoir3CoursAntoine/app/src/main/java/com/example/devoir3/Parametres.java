package com.example.devoir3;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import android.widget.TextView;



public class Parametres extends AppCompatActivity {
    TextView tvParamètres;
    ImageView ivMonProfilParametres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
    }

    //Lorsque l'utilisateur clique sur l'icône "<", il est ramené vers la page précédente
    public void quitterParam(View v){ this.finish(); }
}



