package org.hugoandrade.calendario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import org.hugoandrade.calendarviewapp.R;


public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegistrar = findViewById(R.id.botonRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToPrincipal();
            }
        });
    }

    private void navigateToPrincipal() {
        Intent i = new Intent(this, CalendarViewWithNotesActivitySDK21.class);
        startActivity(i);
    }
}

