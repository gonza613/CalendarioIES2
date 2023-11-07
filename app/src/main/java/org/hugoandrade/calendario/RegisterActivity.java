package org.hugoandrade.calendario;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.hugoandrade.calendarviewapp.R;

import java.security.Provider;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnRegistrar;
    EditText emailEditText;
    EditText passwordEditText;
    EditText editTextPasswordRepeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //mAuth=FirebaseAuth.getInstance();
        editTextPasswordRepeat=findViewById(R.id.editTextPasswordRepeat);
        passwordEditText= findViewById(R.id.editTextPassword);
        emailEditText= findViewById(R.id.emailEditText);
        btnRegistrar = findViewById(R.id.botonRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void navigateToPrincipal() {
        Intent i = new Intent(this, CalendarViewWithNotesActivitySDK21.class);
        startActivity(i);
    }

    private void validate(){
        String email=emailEditText.getText().toString().trim();
        String password=passwordEditText.getText().toString().trim();
        String rpassword=passwordEditText.getText().toString().trim();
        if (email.isEmpty()){
            emailEditText.setError("Correo invalido");
            return;
        } else {
            emailEditText.setError(null);
        }

        if (password.isEmpty() || password.length()<8){
            passwordEditText.setError("Se necesita mas de 8 caracteres");
            return;
        } else {
            passwordEditText.setError(null);
        }

        if(!editTextPasswordRepeat.equals(password)){
            editTextPasswordRepeat.setError("Deben ser iguales");
        } else {
            registrar(email,password);
        }

    }

    private void registrar(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent i= new Intent(RegisterActivity.this, CalendarViewWithNotesActivitySDK21.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Fallo al registrarse", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}


