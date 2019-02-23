package sergiosenem.examples.devmobile.example1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Activity1 extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    public void der(View view){
        TextView t = findViewById(R.id.contextText);

        if(counter == 0) {
            t.setText("Obrigado! :)");
        }
        else{
            t.setText("Orbigado! :) Kill score: " + counter);
        }

        counter++;
        randomNumber(view);
    }

    public void randomNumber(View view){
        Random random = new Random();
        int number;
        TextView t = findViewById(R.id.randoNum);

        number = random.nextInt(10);

        t.setText("Random: " + number);
    }
}
