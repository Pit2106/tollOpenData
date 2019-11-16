package com.pruebas.peajeopendata.openDataAPI;

import com.pruebas.peajeopendata.Models.OpenResponse;
import com.pruebas.peajeopendata.Models.Toll;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface OpenDataService {
    @GET("jhpq-24h2.json")
    Call<List<Toll>> getDataList(@Query("$limit") int limit, @Query("$offset")int offset);
}
