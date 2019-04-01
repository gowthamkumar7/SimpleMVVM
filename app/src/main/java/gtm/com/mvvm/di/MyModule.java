package gtm.com.mvvm.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import gtm.com.mvvm.MvvmApplication;
import gtm.com.mvvm.api.ApiService;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * @author gowtham pr on 4/1/2019.
 */

@Module public class MyModule {

  MvvmApplication mvvmApplication;

  public MyModule(MvvmApplication mvvmApplication) {
    this.mvvmApplication = mvvmApplication;
  }

  @Provides Context providesApplication() {
    return mvvmApplication;
  }

  @Provides @Singleton ApiService providesApiHelper(Retrofit retrofit) {

    return retrofit.create(ApiService.class);
  }
}
