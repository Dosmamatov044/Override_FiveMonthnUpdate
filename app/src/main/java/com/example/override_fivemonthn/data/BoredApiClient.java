package com.example.override_fivemonthn.data;

import android.util.Log;

import com.example.override_fivemonthn.model.BoredAction;



import org.jetbrains.annotations.NotNull;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class BoredApiClient  {













    Retrofit retrofit =(Retrofit) new Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();






        BoredApi client = retrofit.create(BoredApi.class);


    @NotNull
    @Override
    public String toString() {
        return "BoredApiClient{" +
                "retrofit=" + retrofit +
                ", client=" + client +
                '}';
    }

    public  void  getAction(String type, Float minPrice, String Activity, String key, String participents, Float Maxprice, String link, Float accessibility, BoredActionCallback callback){
        Call <BoredAction>  call = client.getAction(type,minPrice,Activity,key,participents,Maxprice,link,accessibility);


        Log.d("ololo", call.request().url().toString());

        call.enqueue(new Callback <BoredAction>(){



            @Override
            public void onResponse(@NotNull Call<BoredAction> call, @NotNull Response<BoredAction> response) {
                if (response.isSuccessful()) {

                    if (response.body() !=null){
                        callback.onSuccess( response.body());
                    }else{


                        callback.onFailure(new Exception("Body is empty" + response.code()));
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<BoredAction> call, @NotNull Throwable t) {

            }


        });

    }





public  interface  BoredActionCallback {
    void onSuccess(BoredAction boredActivity);
    void onFailure(Exception exception);



}




    public interface BoredApi    {
        @GET("api/activity/")


        Call<BoredAction> getAction(


                @Query("type") String type,
                @Query("minprice")  Float minPrice,
                @Query("activity")String activity,
                @Query("key") String key,
                @Query("participents") String participents,
                @Query("price") Float Maxprice,
                @Query("link")String link,
                @Query("accessibility") Float accessibility);







    }



}
