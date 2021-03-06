package com.aprendiz.ragp.proyectopsp8.Controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.proyectopsp8.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefectLog extends AppCompatActivity implements View.OnClickListener {

    EditText txtDate, txtFix, txtDescription;
    Button btnDate, btngo, btnstop, btnrestart;
    Spinner spinnerType, spinnerPhaseIn, spinnerPhaseRe;
    Date date;

    boolean bandera = true;
    boolean bandera1 = false;

    Thread thread;

    int [] tiempo = {0,0};


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);


        //Creamos metodos
        inicializar();
        escuchar();
        listar();
        validar();
        cronometro();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    // Option del boton de devolver a la anterior actividad
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        switch (id){
            case android.R.id.home:

                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    // Creamos metodo para correr el cronometro, Iniciar, Parar y reiniciar

    private void cronometro() {

        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (bandera) {
                    try {
                        {
                            Thread.sleep(1000);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                if (bandera1) {
                                    tiempo[0]++;
                                    if (tiempo[0] == 60) {
                                        tiempo[1]++;
                                        tiempo[0] = 0;
                                    }

                                    if (tiempo[0] >= 0 && tiempo[0] < 10) {
                                        if (tiempo[0] >= 0 && tiempo[0] < 10) {
                                            txtFix.setText("0" + tiempo[1] + ":" + "0" + tiempo[0]);
                                        } else {

                                            txtFix.setText(tiempo[1] + ":" + "0" + tiempo[0]);
                                        }
                                    }


                                    if (tiempo[0] >= 10 && tiempo[0] < 60) {
                                        if (tiempo[0] >= 0 && tiempo[0] < 10) {
                                            txtFix.setText("0" + tiempo[1] + ":" + tiempo[0]);

                                        } else {

                                            txtFix.setText(tiempo[1] + ":" + tiempo[0]);
                                        }
                                    }
                                }

                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    //Metodo validar el cual no deja regstrar si faltan campos
    private void validar() {

        int validar = 0;

        if (txtDate.getText().toString().length()>0){
            validar++;

        }else {
            txtDate.setError("You need this field");
        }
        if (txtFix.getText().toString().length()>0){

            validar++;
        }else {

            txtFix.setError("You need this field");
        }



    }

    //Metodo listar, Generamos la lista para los spinners
    private void listar() {


        List<String>Type = new ArrayList<>();
        Type.add("Documentation");
        Type.add("Syntax");
        Type.add("Build");
        Type.add("Package");
        Type.add("Assigment");
        Type.add("Interface");
        Type.add("Checking");
        Type.add("Data");
        Type.add("Function");
        Type.add("System");
        Type.add("Environment");

        List<String>phases = new ArrayList<>();
        phases.add("PLAN");
        phases.add("DLC");
        phases.add("CODE");
        phases.add("COMPILE");
        phases.add("UT");
        phases.add("PM");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Type);
        spinnerType.setAdapter(adapter);

        ArrayAdapter adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, phases);
        spinnerPhaseRe.setAdapter(adapter1);
        spinnerPhaseIn.setAdapter(adapter1);

    }
    //LLamamos los botones para que sean "escuchados"

    private void escuchar() {

        btnrestart.setOnClickListener(this);
        btngo.setOnClickListener(this);
        btnstop.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }
    //Inicializamos los campos de los layout

    private void inicializar() {

        txtDate = findViewById(R.id.txtDate);
        txtFix = findViewById(R.id.txtfixTime);
        txtDescription = findViewById(R.id.txtDescripcion);

        spinnerType = findViewById(R.id.SpinnerType);
        spinnerPhaseIn = findViewById(R.id.SpinnerPhaseInjected);
        spinnerPhaseRe = findViewById(R.id.SpinnerPhaseRemoved);

        btnDate = findViewById(R.id.btnDate);
        btngo = findViewById(R.id.btnGo);
        btnstop = findViewById(R.id.btnStop);
        btnrestart = findViewById(R.id.btnRestart);

    }

    //Metodo del OnClickListener Donde generamos las funciones para los botones
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnDate:

                date = new Date();
                SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  // Tomamos la hora y fehca del celular
                String fecha1 = fecha.format(date);
                txtDate.setText(fecha1);

                break;


            case R.id.btnGo:

                bandera1 = true;
                Toast.makeText(this, "Go", Toast.LENGTH_SHORT).show();
                break;


            case R.id.btnStop:

                bandera1 =false;
                Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnRestart:

                bandera1 = false;
                tiempo[0]=0;
                tiempo[1]=0;
                txtFix.setText("0" + tiempo[1] + ":" + "0" + tiempo[0]);
                Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show();

                break;

        }

    }
}
