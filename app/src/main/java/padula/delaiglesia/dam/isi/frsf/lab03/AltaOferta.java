package padula.delaiglesia.dam.isi.frsf.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AltaOferta extends AppCompatActivity {
    Spinner spinnerCategorias;
    Spinner spinnerMonedas;
    Button btnCrear;
    EditText txtDescripcion;
    EditText txtHoras;
    EditText txtPrecioHora;

    String[] monedas = {"USD","EUR","ARS","LIBRA","REAL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_oferta);
        btnCrear = (Button) findViewById(R.id.button);
        txtDescripcion = (EditText) findViewById(R.id.editText);
        txtHoras = (EditText) findViewById(R.id.editText4);
        txtPrecioHora = (EditText) findViewById(R.id.editText3);

        spinnerCategorias = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapterCategorias = new ArrayAdapter<Categoria>(this,android.R.layout.simple_spinner_item,Categoria.CATEGORIAS_MOCK);
        spinnerCategorias.setAdapter(adapterCategorias);

        spinnerMonedas = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapterMonedas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,monedas);
        spinnerMonedas.setAdapter(adapterMonedas);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trabajo t = new Trabajo();
                t.setCategoria((Categoria)spinnerCategorias.getSelectedItem());
                t.setMonedaPago((int)spinnerMonedas.getSelectedItem());
                t.setDescripcion(txtDescripcion.getText().toString());
                t.setPrecioMaximoHora(Double.parseDouble(txtPrecioHora.getText().toString()));
                t.setHorasPresupuestadas(Integer.parseInt(txtHoras.getText().toString()));

                Intent i = getIntent();

                i.putExtra("OFERTA",t);
                finish();

            }
        });
    }

}
