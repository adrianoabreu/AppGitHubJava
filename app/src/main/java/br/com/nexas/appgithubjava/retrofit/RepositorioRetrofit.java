package br.com.nexas.appgithubjava.retrofit;

import br.com.nexas.appgithubjava.service.RepositorioService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by user on 02/11/2017.
 */

public class RepositorioRetrofit {

    private final Retrofit retrofit;
    private static final String BASE_URL = "https://api.github.com";
    public RepositorioRetrofit(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public RepositorioService getRepositorioService(){
        return retrofit.create(RepositorioService.class);
    }
}
