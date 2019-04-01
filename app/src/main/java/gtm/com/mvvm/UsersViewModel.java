package gtm.com.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import gtm.com.mvvm.api.ApiHelper;
import gtm.com.mvvm.api.ApiService;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author gowtham pr on 3/29/2019.
 */
public class UsersViewModel extends AndroidViewModel implements Observer {

  private MutableLiveData<UsersResponse> userList;//=new MutableLiveData<>();

  public UsersViewModel(@NonNull Application application) {
    super(application);

    Log.e("PackageName",""+application.getPackageName());
    Log.e("---",""+application.getApplicationContext());
  }

  public MutableLiveData<UsersResponse> getUserList() {
    if (userList == null) {
      userList = loadUsers();
    }
    return userList;
  }

  private MutableLiveData loadUsers() {
    // do something to load users
    ApiService apiService = ApiHelper.getClient().create(ApiService.class);

    apiService.getUsers()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this);

    return new MutableLiveData<>();
  }

  @Override protected void onCleared() {
    Log.e("UsersViewModel", "onCleared called");
  }

  @Override public void onSubscribe(Disposable d) {

  }

  @Override public void onNext(Object value) {

    if (value instanceof UsersResponse) {

      userList.setValue((UsersResponse) value);
      Log.e("--", "" + ((UsersResponse) value).getData().get(0).getFirstName().toLowerCase());
    }
  }

  @Override public void onError(Throwable e) {

  }

  @Override public void onComplete() {

  }
}
