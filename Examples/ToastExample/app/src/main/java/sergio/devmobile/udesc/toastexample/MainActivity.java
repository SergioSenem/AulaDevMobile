package sergio.devmobile.udesc.toastexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirToast(View view){
        Toast t;
        if(findViewById(R.id.BtnLongToast).getId() == view.getId()) {
            t = Toast.makeText(this, "Hello God", Toast.LENGTH_LONG);
            System.out.println("LONG");
        }
        else{
            t = Toast.makeText(this, "Hello God", Toast.LENGTH_SHORT);
            System.out.println("SHORT");
        }
        t.show();
    }
}
