package com.aprendiz.ragp.proyectopsp8;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aprendiz.ragp.proyectopsp8.Models.AdapterP;
import com.aprendiz.ragp.proyectopsp8.Models.CProject;
import com.aprendiz.ragp.proyectopsp8.Models.ManagerDB;

import java.util.List;

public class MenuPrincipal extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton btnIngresar;
    public static CProject project= new CProject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        inizialite();
        inputAdapter();
        //Ingreso del método setOnClickListener
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Llamado al dialog para el ingreso de proyectos
                final Dialog dialog = new Dialog(MenuPrincipal.this);
                dialog.setContentView(R.layout.item_aprojecto);
                dialog.setCancelable(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                final EditText txtProjecto = dialog.findViewById(R.id.txtNombreP);
                final EditText txtTiempo = dialog.findViewById(R.id.txtTiempoP);
                Button btnAceptar = dialog.findViewById(R.id.btnAceptar);
                Button btnCancelar = dialog.findViewById(R.id.btnCancelar);
                btnAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CProject project = new CProject();
                        String nombre = txtProjecto.getText().toString();
                        int tiempo=0;
                        try {
                            tiempo=Integer.parseInt(txtTiempo.getText().toString());
                        }catch (Exception e){
                            Toast.makeText(MenuPrincipal.this, "Por favor ingresa un tiempo valido", Toast.LENGTH_SHORT).show();
                            txtTiempo.setError("Por favor ingresa un tiempo valido");
                        }
                        if (nombre.length()>0 && tiempo>0 ) {
                            project.setNombre(nombre);
                            project.setTime(tiempo);
                            ManagerDB managerDB = new ManagerDB(MenuPrincipal.this);
                            managerDB.inputProject(project);
                            inputAdapter();
                            dialog.cancel();


                        }else if(nombre.length()<=0){
                            Toast.makeText(MenuPrincipal.this, "Por favor ingresa un nombre válido", Toast.LENGTH_SHORT).show();
                            txtTiempo.setError("Por favor ingresa un nombre válido");
                        }
                    }
                });

                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
    }

    //Método para inizializar
    private void inizialite() {
        recyclerView = findViewById(R.id.recyclerView);
        btnIngresar = findViewById(R.id.btnIngresarP);
    }

    //Método para el ingreso del adaptador al recyclerView
    private void inputAdapter() {
        ManagerDB managerDB = new ManagerDB(this);
        final List<CProject> projects = managerDB.projectList();
        AdapterP adapterP = new AdapterP(projects);
        recyclerView.setAdapter(adapterP);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        adapterP.setMlistener(new AdapterP.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                project=projects.get(position);
            }
        });


    }
}
