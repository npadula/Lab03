package padula.delaiglesia.dam.isi.frsf.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class AltaOferta extends AppCompatActivity {
    Spinner spinnerCategorias;
    Spinner spinnerMonedas;
    Button btnCrear;
    EditText txtDescripcion;
    EditText txtHoras;
    EditText txtPrecioHora;
    CheckBox checkbox;

    String[] monedas = {"USD","EUR","ARS","LIBRA","REAL"};
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_oferta);
        btnCrear = (Button) findViewById(R.id.button);
        txtDescripcion = (EditText) findViewById(R.id.editText);
        txtHoras = (EditText) findViewById(R.id.editText4);
        txtPrecioHora = (EditText) findViewById(R.id.editText3);
        checkbox = (CheckBox) findViewById(R.id.checkBox);

        spinnerCategorias = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapterCategorias = new ArrayAdapter<Categoria>(this,android.R.layout.simple_spinner_item,Categoria.CATEGORIAS_MOCK);
        spinnerCategorias.setAdapter(adapterCategorias);

        spinnerMonedas = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapterMonedas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,monedas);
        spinnerMonedas.setAdapter(adapterMonedas);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Trabajo t = new Trabajo();
                    t.setCategoria((Categoria)spinnerCategorias.getSelectedItem());
                    t.setHorasPresupuestadas(Integer.parseInt(txtHoras.getText().toString()));
                    t.setMonedaPago(spinnerMonedas.getSelectedItemPosition());
                    t.setDescripcion(txtDescripcion.getText().toString());
                    t.setPrecioMaximoHora(Double.parseDouble(txtPrecioHora.getText().toString()));
                    t.setRequiereIngles(checkbox.isChecked());
                    t.setId(Trabajo.getNewID());

                    i = getIntent();

                    i.putExtra("OFERTA",t);
                    setResult(RESULT_OK, i);
                    finish();
                }
                catch (Exception ex){
                    setResult(RESULT_CANCELED,i);
                    finish();
                }

            }
        });
    }

}
