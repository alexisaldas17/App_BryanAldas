package fisei.uta.ec.app_bryanaldas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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

                String items = etNombre.getText().toString() + "_" + etApellido.getText().toString() + "_"
                        + etBase.getText().toString() + "_" + etExponente.getText().toString() + "_" + etNumero.getText().toString();

                Intent intent = new Intent();
                intent.setData(Uri.parse(items));

                setResult(Activity.RESULT_OK, intent);

                startActivity(intent);
                finish();
            }
        });
    }


}