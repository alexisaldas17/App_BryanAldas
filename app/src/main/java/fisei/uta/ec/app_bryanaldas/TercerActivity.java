package fisei.uta.ec.app_bryanaldas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TercerActivity extends AppCompatActivity {
    EditText etNombre;
    EditText etApellido;
    EditText etBase;
    EditText etExponente;
    EditText etNumero;
     Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
        etNombre = findViewById(R.id.editTextNombreTA);
        etApellido = findViewById(R.id.editTextApellidoTA);
        etBase = findViewById(R.id.editTextBaseTA);
        etExponente = findViewById(R.id.editTextExponenteTA);
        etNumero = findViewById(R.id.editTextNumeroTA);
        btnCerrar = findViewById(R.id.buttonCerrarTA);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String base = etBase.getText().toString();
                String exponente = etExponente.getText().toString();
                String numero = etNumero.getText().toString();


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Intent intent2 = new Intent(getApplicationContext(), SegundaActivity.class);
                intent2.putExtra("nombreSA", nombre);
                intent2.putExtra("baseSA",base);

                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido",apellido);
                intent.putExtra("base",base);
                intent.putExtra("exponente",exponente);
                intent.putExtra("numero",numero);


                startActivity(intent2);
                finish();
            }
        });
    }


}