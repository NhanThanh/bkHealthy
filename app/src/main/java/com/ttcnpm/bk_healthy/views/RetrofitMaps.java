package com.ttcnpm.bk_healthy.views;

import com.ttcnpm.bk_healthy.model.Example;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by phuongcse on 04/05/2017.
 */
public interface RetrofitMaps {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("api/directions/json?key=AIzaSyBVYoF7lP481m0DHudNhH3rcffuwNBIs3A")
    Call<Example> getDistanceDuration(@Query("units") String units, @Query("origin") String origin, @Query("destination") String destination, @Query("mode") String mode);

}
