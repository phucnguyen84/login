package com.volio.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LoginSuccess extends AppCompatActivity{
    TextView txtInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        addControls();
        txtInfor.setText(MainActivity.DisplayData);
    }

    private void addControls() {
        txtInfor=findViewById(R.id.txtInfor);
    }
}
