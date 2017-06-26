package mx.com.oexl.a170523_contactosoexl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Raul on 26/06/2017.
 */
public class Main2Activity extends AppCompatActivity {
    private TextView vNombre2;
    private TextView vTelefono2;
    private TextView vEmail2;
    private TextView vFecha2;
    private TextView vDescripcion2;
    private Button vEditar;

    String nombre, telefono, email, descripcion, dia, mes, anio, fechaA1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        vNombre2 = (TextView) findViewById(R.id.tvNombre2);
        vTelefono2 = (TextView) findViewById(R.id.tvTelefono2);
        vEmail2 = (TextView) findViewById(R.id.tvCorreo2);
        vDescripcion2 = (TextView) findViewById(R.id.tvDescrip2);
        vFecha2 = (TextView) findViewById(R.id.tvFecha2);
        vEditar = (Button) findViewById(R.id.tvEditar);

        Bundle bundle = this.getIntent().getExtras();
        nombre = bundle.getString("vNombre");
        telefono = bundle.getString("vTelefono");
        email = bundle.getString("vEmail");
        descripcion = bundle.getString("vDescripcion");
        mes = bundle.getString("mes");
        dia = bundle.getString("dia");
        anio = bundle.getString("anio");
        fechaA1 = (dia + "/" + mes + "/" + anio);

        vNombre2.setText(nombre);
        vTelefono2.setText(telefono);
        vEmail2.setText(email);
        vDescripcion2.setText(descripcion);
        vFecha2.setText(fechaA1);


        vEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reEnviarDatos();
            }
        });


    }

    public void reEnviarDatos() {
        String nombre, telefono, correo, descripcion, mesE, diaE, anioE;
        nombre = vNombre2.getText().toString();
        telefono = vTelefono2.getText().toString();
        correo = vEmail2.getText().toString();
        descripcion = vDescripcion2.getText().toString();
        mesE = mes.toString();
        diaE = dia.toString();
        anioE = anio.toString();
        Intent i = new Intent(Main2Activity.this, MainActivity.class);
        //intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());

        //  intent.putExtra("variable_integer", objeto.getId());

        i.putExtra("vNombre2", nombre);
        i.putExtra("vTelefono2", telefono);
        i.putExtra("vEmail2", correo);
        i.putExtra("vDescripcion2", descripcion);
        i.putExtra("mes", mesE);
        i.putExtra("dia", diaE);
        i.putExtra("anio", anioE);
        startActivity(i);
    }
}
