package com.rapariscode.simplecontacto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Contacto contacto;

    private TextInputEditText nombre; // =  (TextInputEditText) findViewById( R.id.inputNombre);
    private TextInputEditText telefono;
    private TextInputEditText email;
    private TextInputEditText descripcion;
    private DatePicker fechaNac;
    private Date dateFechaNac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre =  (TextInputEditText) findViewById( R.id.inputNombre);
        telefono =  (TextInputEditText) findViewById( R.id.inputTelefono);
        email =  (TextInputEditText) findViewById( R.id.inputEmail);
        descripcion =  (TextInputEditText) findViewById( R.id.inputDescripcion);
        fechaNac = (DatePicker) findViewById( R.id.datePicker );
        contacto = new Contacto();

        Bundle parametros = getIntent().getExtras();

        if ( parametros != null ) {
            String snombre = parametros.getString(getResources().getString(R.string.pnom));
            String stelefono = parametros.getString(getResources().getString(R.string.ptel));
            String semail = parametros.getString(getResources().getString(R.string.pema));
            String sdescripcion = parametros.getString(getResources().getString(R.string.pdes));
            int dia = parametros.getInt( getResources().getString(R.string.pdia));
            int mes = parametros.getInt( getResources().getString(R.string.pmes));
            int año = parametros.getInt( getResources().getString(R.string.paño));

            nombre.setText( snombre );
            telefono.setText( stelefono );
            email.setText( semail );
            descripcion.setText( sdescripcion );
            fechaNac.updateDate( año, mes-1, dia );

        }
    }

    private boolean validarDatos( String nombre, String telefono ) {
        boolean good2go = false;

        if ( nombre.trim().length() > 0 && telefono.trim().length() > 0 ) {
            good2go = true;
        }

        return good2go;
    }

    public void getFecha(View v) {

        //DialogFragment newFragment = new DatePickerFragment();
        //newFragment.show(getSupportFragmentManager(), "datePicker");

        contacto.setDia( fechaNac.getDayOfMonth() );
        contacto.setMes( fechaNac.getMonth() + 1 );
        contacto.setAño( fechaNac.getYear() );
        contacto.setNombre( nombre.getText().toString() );
        contacto.setTelefono( telefono.getText().toString() );
        contacto.setDescripcion( descripcion.getText().toString() );
        contacto.setEmail( email.getText().toString() );

        if ( ! validarDatos( contacto.getNombre(), contacto.getTelefono() ) ) {
            Toast.makeText(this,getResources().getString(R.string.mensajeFaltanDatos),Toast.LENGTH_LONG).show();
        } else {
            Intent cDatos = new Intent(this, ConfirmarDatos.class);
            cDatos.putExtra("nombre", contacto.getNombre());
            cDatos.putExtra("telefono", contacto.getTelefono());
            cDatos.putExtra("email", contacto.getEmail());
            cDatos.putExtra("descripcion", contacto.getDescripcion());
            cDatos.putExtra("dia", contacto.getDia());
            cDatos.putExtra("mes", contacto.getMes());
            cDatos.putExtra("año", contacto.getAño());

            startActivity(cDatos);
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
