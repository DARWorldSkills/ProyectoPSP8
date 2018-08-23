package com.aprendiz.ragp.proyectopsp8.Controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.aprendiz.ragp.proyectopsp8.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimerLog extends AppCompatActivity implements View.OnClickListener {

    Spinner spinnerPhas;
    EditText txtStart, txtInterupcion, txtStop, txtDelta, txtComentarios;
    Button btnStart, btnStop;

    Date date;

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
        setContentView(R.layout.activity_timer_log);


        inicializar();
        escuchar();
        Listar();
        validar();


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void validar() {

        int validar = 0;

        if (txtStart.getText().toString().length()>0){
            validar++;

        }else {
            txtStart.setError("You need this field");
        }
        if (txtStop.getText().toString().length() >0){
            validar++;
        }else {
            txtStop.setError("You need this field");
        }

    }

    private void Listar() {


        List<String>phase = new ArrayList<>();
        phase.add("PLAN");
        phase.add("DLD");
        phase.add("CODE");
        phase.add("COMPILE");
        phase.add("UT");
        phase.add("PM");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, phase);
        spinnerPhas.setAdapter(adapter);
    }

    private void escuchar() {
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    private void inicializar() {

        spinnerPhas = findViewById(R.id.SpinnerPhase);

        txtStart = findViewById(R.id.txtStart);
        txtStop = findViewById(R.id.txtStop);
        txtInterupcion = findViewById(R.id.txtInterrupciones);
        txtDelta = findViewById(R.id.txtDelta);
        txtComentarios = findViewById(R.id.txtComentarios);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnStart:

               date = new Date();
                SimpleDateFormat fecha =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String fecha1 = fecha.format(date);
                txtStart.setText(fecha1);


                break;


            case R.id.btnStop:

                date = new Date();
                SimpleDateFormat stop = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String stop1 = stop.format(date);
                txtStop.setText(stop1);

                break;
        }


    }
}
