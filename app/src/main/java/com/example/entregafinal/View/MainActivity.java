package com.example.entregafinal.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import com.example.entregafinal.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        navigationView = findViewById(R.id.navigationView);
//        ListenerDelNavigationView listenerDelNavigationView = new ListenerDelNavigationView();
//        navigationView.setNavigationItemSelectedListener(listenerDelNavigationView);

        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
    }

//    private class ListenerDelNavigationView implements NavigationView.OnNavigationItemSelectedListener{
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            selectedMenuItem(menuItem);
//            return true;
//        }
//    }
//
//    private void selectedMenuItem(MenuItem item){
//        if (item.getItemId() == R.id.login){
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//
//        } else if (item.getItemId() == R.id.about) {
//            Intent intent = new Intent(this,AboutUs.class);
//            startActivity(intent);
//        }
//
//
//    }



    private boolean validateUsername() {
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputUsername.setError("No puede ser vacio");
            return false;
        } else if (usernameInput.length() > 20) {
            textInputUsername.setError("usuario demasiado largo");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("No puede ser vacio");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("La contraseña debe tener una Mayuscula y un numero");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateUsername() | !validatePassword()) {
            return;
        }

        Intent intent = new Intent(MainActivity.this,LoggedActivity.class);
        startActivity(intent);
    }


    }
