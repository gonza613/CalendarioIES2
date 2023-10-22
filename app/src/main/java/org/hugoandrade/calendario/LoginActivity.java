package org.hugoandrade.calendario;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.hugoandrade.calendarviewapp.R;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnIngresar = findViewById(R.id.botonIngresar);
        TextView btnRegistrar= findViewById(R.id.textViewRegristro);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToPrincipal();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { navigateToRegister(); }
        });
    }

    private void navigateToPrincipal() {
        Intent intent = new Intent(this, CalendarViewWithNotesActivitySDK21.class);
        startActivity(intent);
    }

    private void navigateToRegister(){
        Intent intent= new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}

