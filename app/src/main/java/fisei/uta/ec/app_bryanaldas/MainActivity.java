package fisei.uta.ec.app_bryanaldas;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNombre;
    EditText etApellido;
    EditText etBase;
    EditText etExponente;
    EditText etFactorial;
    EditText etPotencia;
    Button btnSiguiente;
    Button btnMostrarResultados;
    ActivityResultLauncher<Intent> resultado;
    String datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNombre = findViewById(R.id.editTextNombreMA);
        etApellido = findViewById(R.id.editTextApellidoMA);
        etBase = findViewById(R.id.editTextBaseMA);
        etExponente = findViewById(R.id.editTextExponenteMA);
        etFactorial = findViewById(R.id.editTextFactorialMA);
        etPotencia = findViewById(R.id.editTextPotenciaMA);
        //BOTONES
        btnSiguiente = findViewById(R.id.buttonSiguienteMA);
        btnMostrarResultados = findViewById(R.id.buttonMostrarResultados);

        btnMostrarResultados.setEnabled(false);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                resultado.launch(intent);
            }
        });
        resultado = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            datos = result.getData().getDataString();
                            String[] items = datos.split("_");
                            etNombre.setText(items[0]);
                            etApellido.setText(items[1]);
                            etBase.setText(items[2]);
                            etExponente.setText(items[3]);
                            btnMostrarResultados.setEnabled(true);
                        }
                    }
                });

                btnMostrarResultados.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String[] items = datos.split("_");
                        int factorial = Integer.valueOf(items[4]);
                        int potencia = factorial;
                        etFactorial.setText(items[4]);
                        etPotencia.setText(String.valueOf(potencia));
                    }
                });

    }
    public int factorial(int numero){
            int factorial =1;
            for (int i=1; i<=numero; i++){
                factorial = i * factorial;
            }

            return  factorial;
    }

    public  int DevolverPotencia(int base, int exponente){
        int p=1;
        while (exponente>0){
            p=p*base;
            exponente--;
        }
        return p;
    }
}