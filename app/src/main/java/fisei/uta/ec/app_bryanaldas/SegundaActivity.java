package fisei.uta.ec.app_bryanaldas;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SegundaActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etBase;
    Button btnSiguiente;
    Button btnCerrar;
    ActivityResultLauncher<Intent> resultado;
    String datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        etNombre = findViewById(R.id.editTextNombreSA);
        etBase = findViewById(R.id.editTextBaseSA);
        btnSiguiente = findViewById(R.id.buttonSiguienteSA);
        btnCerrar = findViewById(R.id.buttonCerrarSA);


        resultado = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            datos = result.getData().getDataString();
                            String[] items = datos.split("_");
                            etNombre.setText(items[0]);
                            etBase.setText(items[2]);
                            btnCerrar.setEnabled(true);
                        }
                    }
                });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TercerActivity.class);
                resultado.launch(intent);
                finish();
            }
        });
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(datos));

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }
}