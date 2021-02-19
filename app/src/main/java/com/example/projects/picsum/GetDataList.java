package com.example.projects.picsum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataList {

    @GET("list")
    Call<List<Data>> getData();
}
