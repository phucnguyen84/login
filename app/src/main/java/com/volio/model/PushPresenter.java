package com.volio.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import com.volio.login.LoginSuccess;
import com.volio.login.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PushPresenter {
    public static LoadDataListener listener;
    public static String BareUrl="https://api.gymmaster.vn/";
    public static boolean check=false;

    public PushPresenter(LoadDataListener listener) {
        this.listener = listener;
    }

    public void getCurrentData(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BareUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoadDataListener service=retrofit.create(LoadDataListener.class);
        Call<Example> call=service.getCurrentUserData(MainActivity.dataEntered);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.code()==200){
                    Example data=response.body();
                    assert data!=null;
                    String stringBuilder="ID: "+data.getData().getUser().getId()+"\n"
                            +"UserName: "+data.getData().getUser().getUsername()+"\n"
                            +"First Name: "+data.getData().getUser().getFirstname()+"\n"
                            +"Last Name: "+data.getData().getUser().getLastname()+"\n"
                            +"Email: "+data.getData().getUser().getEmail();
                    listener.onLoadDataSuccess(stringBuilder);
                    check=true;
                }
                else{
                    Example data=response.body();
                    listener.onLoadDataFailure(data.getMeta().getMessage());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                String message=t.getMessage();
                listener.onLoadDataFailure(message);
            }
        });
    }

}
