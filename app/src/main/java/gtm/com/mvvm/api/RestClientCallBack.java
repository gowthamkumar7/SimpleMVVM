package gtm.com.mvvm.api;

import retrofit2.Response;

/**
 * @author gowtham pr
 *
 *         Call back interface for network calls
 */

public interface RestClientCallBack {

  void onSuccess(int responseCode, Response<Object> response, int requestCode);

  void onError(int responseCode, Response<Object> error, int requestCode);

  void onFailure(Throwable throwable, int requestCode);
}
