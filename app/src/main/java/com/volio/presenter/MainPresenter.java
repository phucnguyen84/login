package com.volio.presenter;

import android.view.View;

import com.volio.login.LoginView;
import com.volio.model.DataEntered;
import com.volio.model.Example;
import com.volio.model.LoadDataListener;
import com.volio.model.PushPresenter;

import retrofit2.Call;

public class MainPresenter implements LoadDataListener {
    private PushPresenter pushPresenter;
    private LoginView loginView;

    public MainPresenter(LoginView loginView) {
        this.loginView = loginView;
        pushPresenter = new PushPresenter(this);
    }

    public void loadData(){
        pushPresenter.getCurrentData();
    }
    @Override
    public void onLoadDataSuccess(String data) {
        loginView.displayLogin(data);
    }

    @Override
    public void onLoadDataFailure(String message) {
        loginView.displayLogin(message);
    }

    @Override
    public Call<Example> getCurrentUserData(DataEntered dataEntered) {
        return null;
    }
}
