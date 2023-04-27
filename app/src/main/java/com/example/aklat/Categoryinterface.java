package com.example.aklat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Categoryinterface {
@GET("categories.php")
 Call<Root> getCategories();

 @GET("filter.php?c=")
 Call<Rootmeal> getMealByCategory(@Query("c") String category);
 @GET("lookup.php?i=")
 Call<Rootdec> getdecbyMeal(@Query("i") String dec);
 @GET("search.php")
 Call<Rootmeal> searchMeal(@Query("s") String dec);

}
