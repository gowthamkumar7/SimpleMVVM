package gtm.com.mvvm.api;

import android.arch.lifecycle.MutableLiveData;
import gtm.com.mvvm.UsersResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author gowtham pr
 *         <p>
 *         This interface used to to constructs Http request and returns response to caller's
 *         class.
 *         All network call returns Object type and sends required model objects/JsonObjects to
 *         server.
 */

public interface ApiService {

  @GET("/api/users") Observable<UsersResponse> getUsers();
}
