package mx.com.oexl.a170523_contactosoexl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView vNombre;
    private TextView vTelefono;
    private TextView vEmail;
    private TextView vDescripcion;
    private DatePicker vPicker;
    private Button vEjecutar;
    private Button vCalendario;
    String nombreA1, telefonoA1, emailA1, descripcionA1, diaA1, mesA1, anioA1, fechaA1;
    Integer diaA;
    Integer mesA;
    Integer anioA;
    Boolean califica = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = this.getIntent();
        if (intent != null){
            nombreA1 = intent.getStringExtra("vNombre2");
            telefonoA1 = intent.getStringExtra("vTelefono2");
            emailA1 = intent.getStringExtra("vEmail2");
            descripcionA1 = intent.getStringExtra("vDescripcion2");
            diaA1 = intent.getStringExtra("vDia2");
            mesA1 = intent.getStringExtra("vMes2");
            anioA1 = intent.getStringExtra("vAnio2");
            fechaA1 = diaA1;
          //  System.out.println(fechaA1);

            vNombre = (TextView) findViewById(R.id.campo_nombre);
            vTelefono = (TextView) findViewById(R.id.campo_telefono);
            vEmail = (TextView) findViewById(R.id.campo_email);
            vDescripcion = (TextView) findViewById(R.id.campo_descripcion);
            vPicker = (DatePicker) findViewById(R.id.tvPicker);
            vCalendario = (Button) findViewById(R.id.btnGet);
            vEjecutar = (Button) findViewById(R.id.enviar);




            vNombre.setText(nombreA1);
            vTelefono.setText(telefonoA1);
            vEmail.setText(emailA1);
            vDescripcion.setText(descripcionA1);

            if(califica){
                vPicker.updateDate(Integer.parseInt(diaA1), Integer.parseInt(mesA1), Integer.parseInt(anioA1));
            }
        }

        vCalendario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){recibeFecha();
            }
        });

        vEjecutar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){enviarDatos();
            }
        });


    }

    public void recibeFecha(){
        System.out.println(vPicker + " " + vPicker.getMonth());
        diaA = vPicker.getDayOfMonth();
        mesA = vPicker.getMonth();
        anioA = vPicker.getYear();
    }

    public void enviarDatos(){
        String nombre, telefono,mail,descripcion, mesE,diaE,anioE;
        nombre  = vNombre.getText().toString();
        telefono = vTelefono.getText().toString();
        mail  = vEmail.getText().toString();
        descripcion=vDescripcion.getText().toString();
        mesE = diaA.toString();
        diaE = mesA.toString();
        anioE = anioA.toString();
        Intent i = new Intent(MainActivity.this, Main2Activity.class);


        i.putExtra("vNombre", nombre);
        i.putExtra("vTelefono", telefono);
        i.putExtra("vEmail", mail);
        i.putExtra("vDescripcion", descripcion);
        i.putExtra("dia", diaE);
        i.putExtra("mes", mesE);
        i.putExtra("anio", anioE);
        startActivity(i);
    }
}
