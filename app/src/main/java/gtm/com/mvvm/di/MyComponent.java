package gtm.com.mvvm.di;

import dagger.Component;
import gtm.com.mvvm.MainActivity;
import gtm.com.mvvm.MvvmApplication;

/**
 * @author gowtham pr on 3/31/2019.
 */

@Component(modules = MyModule.class)

public interface MyComponent {

  void inject(MvvmApplication application);
  void inject(MainActivity mainActivity);
}
