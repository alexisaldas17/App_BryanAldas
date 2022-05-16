package fisei.uta.ec.app_bryanaldas;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                startActivity(intent);
                finish();
            }
        });
        Bundle bundle = getIntent().getExtras();
        if(!bundle.isEmpty()){

            etNombre.setText(bundle.getString("nombre"));
            etApellido.setText(bundle.getString("apellido"));
            etBase.setText(bundle.getString("base"));
            etExponente.setText(bundle.getString("exponente"));


            etFactorial.setText(factorial(Integer.parseInt(bundle.getString("numero"))));

            etPotencia.setText(DevolverPotencia(Integer.parseInt(bundle.getString("base")),
                    Integer.parseInt(bundle.getString("exponente"))));
        }



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