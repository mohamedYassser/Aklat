package com.example.aklat;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static Retrofit retrofit = null;

    public ApiController(MealFragment mealFragment) {
    }

    static Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit ;
    }
static Categoryinterface apiinterface = getRetrofit().create(Categoryinterface.class);

}
