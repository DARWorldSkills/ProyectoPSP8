package com.aprendiz.ragp.proyectopsp8.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aprendiz.ragp.proyectopsp8.R;

public class Menu_Proyecto extends AppCompatActivity implements View.OnClickListener{


    Button btnTimer, btnDefect, btnProyectPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__proyecto);


        inicializar();
        escuchar();
    }

    private void escuchar() {
        btnTimer.setOnClickListener(this);
        btnDefect.setOnClickListener(this);
        btnProyectPlan.setOnClickListener(this);

    }

    private void inicializar() {

        btnTimer = findViewById(R.id.btnTimerLog);
        btnDefect = findViewById(R.id.btnDefectLog);
        btnProyectPlan = findViewById(R.id.btnProyectPlanSummary);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnTimerLog:

                Intent intent = new Intent(Menu_Proyecto.this, TimerLog.class);
                startActivity(intent);

                break;


            case R.id.btnDefectLog:
                Intent intent1 = new Intent(Menu_Proyecto.this, DefectLog.class);
                startActivity(intent1);

                break;


            case R.id.btnProyectPlanSummary:

                Intent intent2 = new Intent(Menu_Proyecto.this, ProyectPlanSummary.class);
                startActivity(intent2);

                break;
        }

    }
}
