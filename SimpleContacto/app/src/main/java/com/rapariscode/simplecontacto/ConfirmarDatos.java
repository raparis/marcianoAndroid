package com.rapariscode.simplecontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView nombre; // =  (TextInputEditText) findViewById( R.id.inputNombre);
    private TextView telefono;
    private TextView email;
    private TextView descripcion;
    private TextView fechaNac;

    int idia;
    int imes;
    int iaño;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String snombre = parametros.getString(getResources().getString(R.string.pnom));
        String stelefono = parametros.getString(getResources().getString(R.string.ptel));
        String semail = parametros.getString(getResources().getString(R.string.pema));
        String sdescripcion = parametros.getString(getResources().getString(R.string.pdes));
        idia = parametros.getInt( getResources().getString(R.string.pdia));
        imes = parametros.getInt( getResources().getString(R.string.pmes));
        iaño = parametros.getInt( getResources().getString(R.string.paño));

        nombre = (TextView) findViewById( R.id.tvDatosNombre );
        nombre.setText( snombre );
        telefono = (TextView) findViewById( R.id.tvDatosTelefono );
        telefono.setText( stelefono );
        email = (TextView) findViewById( R.id.tvDatosEmail );
        email.setText( semail );
        descripcion = (TextView) findViewById( R.id.tvDatosDescripcion );
        descripcion.setText( sdescripcion );
        fechaNac = (TextView) findViewById( R.id.tvDatosFechaNacimiento );
        fechaNac.setText( idia + "/" + imes + "/" + iaño );

    }

    public void editarDatos(View view) {
        callMainActivity();
        finish();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            callMainActivity();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void callMainActivity() {
        Intent intent = new Intent( this, MainActivity.class);
        intent.putExtra("nombre", nombre.getText().toString());
        intent.putExtra("telefono", telefono.getText().toString());
        intent.putExtra("email", email.getText().toString());
        intent.putExtra("descripcion", descripcion.getText().toString());
        intent.putExtra("dia", idia );
        intent.putExtra("mes", imes );
        intent.putExtra("año", iaño );
        startActivity( intent );
    }
}
