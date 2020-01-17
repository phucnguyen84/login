package com.volio.model;

import com.volio.login.MainActivity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoadDataListener {
    void onLoadDataSuccess(String data);
    void onLoadDataFailure(String message);

    @POST("api/auth/member/login")
    Call<Example> getCurrentUserData(@Body DataEntered dataEntered);

}
