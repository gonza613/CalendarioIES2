package org.hugoandrade.calendario;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.FirebaseApp;

import org.hugoandrade.calendarviewapp.R;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    TextView btnRegistrar;
    Button btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);


        //Esta dos lineas son las que hacen que se crashee la aplicacion
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //mAuth=FirebaseAuth.getInstance();

        emailEditText= findViewById(R.id.emailEditText);
        passwordEditText= findViewById(R.id.editTextPassword);
        btnIngresar = findViewById(R.id.botonIngresar);
        btnRegistrar= findViewById(R.id.textViewRegristro);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                validate();
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

   private void validate(){
        String email=emailEditText.getText().toString().trim();
        String password=passwordEditText.getText().toString().trim();
        if (email.isEmpty()){
            emailEditText.setError("Correo invalido");
            return;
        } else {
            emailEditText.setError(null);
        }

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
           if (password.isEmpty() || password.length()<8){
               passwordEditText.setError("Se necesita mas de 8 caracteres");
               return;
           } else {
              passwordEditText.setError(null);
           }
       }

       iniciarSesion(email,password);


    }

    public void iniciarSesion(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(LoginActivity.this, CalendarViewWithNotesActivitySDK21.class);
                    startActivity(i);
                    //finish();
                      } else {
                    Toast.makeText(LoginActivity.this, "Email o contraseña incorrecta",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


