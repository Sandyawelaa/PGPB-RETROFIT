package com.example.acara_10.network;

import com.example.acara_10.model.Data;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("3404")
    Call<List<Data>> getAllUsers();
}
