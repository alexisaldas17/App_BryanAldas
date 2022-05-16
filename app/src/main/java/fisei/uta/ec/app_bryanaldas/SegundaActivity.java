package fisei.uta.ec.app_bryanaldas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SegundaActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etBase;
    Button btnSiguiente;
    Button btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        etNombre = findViewById(R.id.editTextNombreSA);
        etBase = findViewById(R.id.editTextBaseSA);
        btnSiguiente = findViewById(R.id.buttonSiguienteSA);
        btnCerrar = findViewById(R.id.buttonCerrarSA);

        btnCerrar.setEnabled(false);

        Bundle bundle = getIntent().getExtras();
        etNombre.setText(bundle.getString("nombreSA"));
        etBase.setText(bundle.getString("baseSA"));


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TercerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}