package sergio.devmobile.udesc.activitylifecicle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.btnLogin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuteLogin();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    private void ExecuteLogin(){

        TextView login = findViewById(R.id.loginInput);
        TextView password = findViewById(R.id.passwordInput);
        String loginInput = login.getText().toString();
        String passwordInput = password.getText().toString();

        if(ValidateInput(loginInput, passwordInput)){
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("login", loginInput);
            startActivity(i);
        }
        else{
            Intent i = new Intent(MainActivity.this, AccessDenied.class);
            startActivity(i);
        }
    }

    private boolean ValidateInput(String loginInput, String passwordInput){
        return loginInput.equals("teste") && passwordInput.equals("123");
    }
}
