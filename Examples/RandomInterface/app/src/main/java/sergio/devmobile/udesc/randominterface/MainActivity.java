package sergio.devmobile.udesc.randominterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setRandom(View view){

        int minValue = getNumberValue(R.id.minNumber);
        int maxValue = getNumberValue(R.id.maxNumber);

        if(validateValues(minValue, maxValue)){
            int interval = maxValue - minValue;

            generateRandom(minValue, interval);
        }
        else{
            Toast.makeText(this, "Valores inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    private int getNumberValue(int inputId){
        EditText inputObject;

        try{
            inputObject = findViewById(inputId);
            int value =  Integer.parseInt(inputObject.getText().toString());

            return value;
        }
        catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT);
            return -1;
        }
        finally{
            inputObject = null;
        }
    }

    private boolean validateValues(int minValue, int maxValue){
        if(minValue == -1 || maxValue == 1){
            return false;
        }

        if(minValue >= maxValue){
            return false;
        }

        return true;
    }

    private void generateRandom(int minNumber, int interval){

        Random random = new Random();

        int randomNumber = random.nextInt(interval + 1) + minNumber;

        TextView result = findViewById(R.id.resultRandom);
        result.setText("Resultado:" + Integer.toString(randomNumber));
    }

}
