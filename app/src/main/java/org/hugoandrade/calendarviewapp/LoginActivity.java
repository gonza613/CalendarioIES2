package org.hugoandrade.calendarviewapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnIngresar = findViewById(R.id.botonIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToPrincipal();
            }
        });
    }

    private void navigateToPrincipal() {
        Intent intent = new Intent(this, CalendarViewWithNotesActivitySDK21.class);
        startActivity(intent);
    }
}

