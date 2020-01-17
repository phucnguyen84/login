package com.volio.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.volio.model.DataEntered;
import com.volio.model.Example;
import com.volio.model.LoadDataListener;
import com.volio.model.PushPresenter;
import com.volio.presenter.MainPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements LoginView {
    private MainPresenter mainPresenter;
    private EditText edtCode,edtUser,edtPassword;
    private String code,user,password;
    public static DataEntered dataEntered;
    public static String DisplayData;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        initPresenter();
        code=edtCode.getText().toString();
        user=edtUser.getText().toString();
        password=edtPassword.getText().toString();
        dataEntered=new DataEntered(user,password,code,"","");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.loadData();
            }
        });
    }

    private void initPresenter() {
        mainPresenter=new MainPresenter(this);
    }

    private void addControls() {
        edtCode=findViewById(R.id.edtCode);
        edtUser=findViewById(R.id.edtUser);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
    }

    @Override
    public void displayLogin(String data) {
        DisplayData=data;
        startActivity(new Intent(MainActivity.this,LoginSuccess.class));
    }
}
