package gtm.com.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  @Inject Context context;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ((MvvmApplication) getApplication()).getComponent().inject(this);

    TextView textView = findViewById(R.id.id_tv);

    textView.setTextColor(context.getColor(R.color.colorAccent));
    UsersViewModel usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
    MutableLiveData<UsersResponse> users = usersViewModel.getUserList();

    users.observe(this,
        usersResponse -> textView.setText(usersResponse.getData().get(0).getFirstName()));
  }
}
