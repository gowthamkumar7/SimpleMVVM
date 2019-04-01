package gtm.com.mvvm.api;

import android.support.annotation.NonNull;
import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Gowtham kumar P R on 31/10/2017.
 * <p>
 * This class creates retrofit and okhttp client and returns it to the caller class.
 */

public class ApiHelper {

  private static Retrofit mRetrofit;
  /*Creates OkHttpClient and adds 60 seconds Timeout*/
  private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
     /* addInterceptor(new ConnectivityInterceptor())
      .readTimeout(Constants.NetworkConstants.CONNECTION_TIME_OUT_PERIOD, TimeUnit.SECONDS)
      .writeTimeout(Constants.NetworkConstants.CONNECTION_TIME_OUT_PERIOD, TimeUnit.SECONDS)
      .connectTimeout(Constants.NetworkConstants.CONNECTION_TIME_OUT_PERIOD, TimeUnit.SECONDS)*/;

  /* Private constructor for not being called from any other classes as this class's instance is singleton.*/
  private ApiHelper() {

  }

  /*
  * Return the singleton retrofit client
  * */
  public static Retrofit getClient() {

    if (mRetrofit == null) {
      addHeaders();
      OkHttpClient client = httpClient.build();
      mRetrofit = new Retrofit.Builder().baseUrl("https://reqres.in")
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .build();
      return mRetrofit;
    } else {
      return mRetrofit;
    }
  }

  /*
  * Add required headers
  * */
  private static void addHeaders() {
    httpClient.addInterceptor(chain -> {
      Request original = chain.request();

      Request request = original.newBuilder()
          .header("Content-Type", "application/json")
          .method(original.method(), original.body())
          .build();

      return chain.proceed(request);
    });
  }



    /*
    *
    * Enqueue the network calls.
    * Send the result back to the respective screens using RestClientCallBack.
    * If any Error or Failure happens it sends the log to Crashlytics.
    * */

  public static void execute(Call<Object> call, RestClientCallBack restClientCallBack,
      int reportIssue) {
    call.enqueue(new Callback<Object>() {

      @Override
      public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
        if (response.body() != null) {
          Log.d("Response-->", "" + response.body());
          restClientCallBack.onSuccess(response.code(), response, reportIssue);
        } else if (response.errorBody() != null) {
          Log.e("Error-->", "" + response.errorBody());
          //                  Crashlytics.logException(new Exception(response.errorBody().toString()));
          restClientCallBack.onError(response.code(), response, reportIssue);
        }
      }

      @Override public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
        Log.e("Failure-->", "" + t.getMessage());
        restClientCallBack.onFailure(t, reportIssue);
      }
    });
  }
}
