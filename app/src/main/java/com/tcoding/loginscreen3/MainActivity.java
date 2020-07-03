package com.tcoding.loginscreen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);

        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        String email_control = sharedPreferences.getString("email",null);
        String password_control = sharedPreferences.getString("password",null);

        if(email_control != null && password_control != null){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("email",email.getText().toString());
                editor.putString("password",password.getText().toString());
                editor.commit();
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                finish();
            }
        });



    }
}
