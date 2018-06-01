package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.User;

import static com.example.user.carrentalapplication.R.string.brunchNum;

public class LogInActivity extends Activity implements View.OnClickListener {
    private EditText user, password;
    private Button reg;


    private void findViews() {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        reg = (Button) findViewById(R.id.button_reg);
        reg.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        findViews();
    }

    private User newUser() {
        String name = (user.getText().toString());
        String pass = (user.getText().toString());
        return new User(name, pass);

    }

    @Override
    public void onClick(View v) {
        String name = (user.getText().toString());
        String pass = (password.getText().toString());
        if (v == reg) {
            if (name.equals("admin") && pass.equals("1234")) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }else
                Toast.makeText(getBaseContext(), "User is not exsist", Toast.LENGTH_SHORT).show();
        }

    }
}
