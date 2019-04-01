package gtm.com.mvvm;

import android.app.Application;
import gtm.com.mvvm.di.DaggerMyComponent;
import gtm.com.mvvm.di.MyComponent;
import gtm.com.mvvm.di.MyModule;

/**
 * @author gowtham pr on 4/1/2019.
 */
public class MvvmApplication extends Application {

  MyComponent component;

  @Override public void onCreate() {
    super.onCreate();

    component = DaggerMyComponent.builder().myModule(new MyModule(this)).build();
    component.inject(this);
  }

  public MyComponent getComponent() {
    return component;
  }
}
