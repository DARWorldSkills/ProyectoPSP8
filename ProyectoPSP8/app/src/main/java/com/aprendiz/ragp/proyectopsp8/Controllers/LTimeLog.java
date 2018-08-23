package com.aprendiz.ragp.proyectopsp8.Controllers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import com.aprendiz.ragp.proyectopsp8.MenuPrincipal;
import com.aprendiz.ragp.proyectopsp8.Models.AdapterP;
import com.aprendiz.ragp.proyectopsp8.Models.AdapterT;
import com.aprendiz.ragp.proyectopsp8.Models.CTimeLog;
import com.aprendiz.ragp.proyectopsp8.Models.ManagerDB;
import com.aprendiz.ragp.proyectopsp8.R;

import java.util.ArrayList;
import java.util.List;

public class LTimeLog extends AppCompatActivity {
    //Declaración de variables
    RecyclerView recyclerView;
    public static int modo=0;
    public static CTimeLog cTimeLog = new CTimeLog();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltime_log);
        recyclerView = findViewById(R.id.recyclerView);
        inputAdapter();
    }

    //Método para ingresar el adaptador en el recyclerView
    private void inputAdapter() {
        final ManagerDB managerDB = new ManagerDB(this);
        final List<CTimeLog> timeLogList = managerDB.timeLogsList(MenuPrincipal.project.getId());
        final AdapterT adapterT = new AdapterT(timeLogList);
        recyclerView.setAdapter(adapterT);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        //Método para cuando se hace click en un item mostrar un alertDialog
        adapterT.setMlistener(new AdapterT.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                cTimeLog = timeLogList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(LTimeLog.this);
                builder.setTitle("¿Qué desea hacer con este timelog");
                builder.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(LTimeLog.this,TimerLog.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder eliminarR = new AlertDialog.Builder(LTimeLog.this);
                        eliminarR.setTitle("¿Éstas seguro de eliminar el timelog?");
                        eliminarR.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                managerDB.deleteTimeLog(cTimeLog);
                                Toast.makeText(LTimeLog.this, "Se ha eliminado el Time Log correctamente", Toast.LENGTH_SHORT).show();
                            }
                        });
                        eliminarR.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        eliminarR.show();
                    }



                });

                builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();

            }
        });

    }
}
