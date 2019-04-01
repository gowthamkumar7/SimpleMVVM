package gtm.com.mvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView textView = findViewById(R.id.list_item);
   /* UsersViewModel usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
    List<String> users = usersViewModel.getUserList();

    textView.setText(users.get(4));*/
  }
}
