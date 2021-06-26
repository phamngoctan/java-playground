package com.tanpham.ddd.restclient.coingecko;

import java.io.IOException;
import java.text.MessageFormat;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CoinGeckoRetrofitSetup {
    private final String API_BASE_URL = "https://api.coingecko.com/api/v3/";

    OkHttpClient okHttpClient = new OkHttpClient.Builder()  
            .cache(null)
            .build();

    private Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create());

    private Retrofit retrofit = builder.build();

    public <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }

    public <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException(MessageFormat.format("Unexpected response when calling coinGecko APIs: {0}", response.toString()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
