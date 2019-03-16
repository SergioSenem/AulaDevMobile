package sergio.devmobile.udesc.activitylifecicle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String login = getIntent().getStringExtra("login");
        TextView t = findViewById(R.id.userName);
        t.setText(t.getText() + " " + login + "!");
    }

    public void exit(View view){
        this.finish();
    }
}
