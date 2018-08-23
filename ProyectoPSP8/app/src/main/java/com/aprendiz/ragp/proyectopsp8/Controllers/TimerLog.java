package com.aprendiz.ragp.proyectopsp8.Controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.aprendiz.ragp.proyectopsp8.R;

public class TimerLog extends AppCompatActivity implements View.OnClickListener {

    Spinner spinnerPhas;
    EditText txtStart, txtInterupcion, txtStop, txtDelta, txtComentarios;
    Button btnStart, btnStop;


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
        //escuchar();


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

    }
}
