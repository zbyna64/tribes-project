package com.gfa.springadvanced.utils;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitializer {

  private static Retrofit retrofit = null;
  public static final String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYjNkNTBmNWQ3NjMyNmNhYzUyMTUyYTExYjU5YTM1YSIsInN1YiI6IjYzZWI1NDc5OGU4NzAyMDA4MjNhYTQ3ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TN7UYjD7zuhUTopLqScQbemQzYTjMoMikNTazro8HLo";

  public static Retrofit getRetrofit() {

    if (retrofit == null) {

      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
          Request newRequest = chain
              .request()
              .newBuilder()
              .addHeader("Authorization", token)
              .build();
          return chain.proceed(newRequest);
        }
      }).build();

      retrofit = new Retrofit.Builder()
          .baseUrl("https://api.themoviedb.org/3/")
          .addConverterFactory(GsonConverterFactory.create())
          .client(client)
          .build();

    }
    return retrofit;
  }
}
