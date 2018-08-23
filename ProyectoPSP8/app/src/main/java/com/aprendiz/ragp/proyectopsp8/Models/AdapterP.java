package com.aprendiz.ragp.proyectopsp8.Models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aprendiz.ragp.proyectopsp8.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterP extends RecyclerView.Adapter<AdapterP.Holder>{
    //Declaración de varables
    List<CProject> cProjectList = new ArrayList<>();
    private OnItemClickListener mlistener;
    //interface para OnItemClickListener
    public interface OnItemClickListener{
        void itemClick(int position);
    }

    //Constructor para la clase AdapterP
    public AdapterP(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    //Setter para la variable mlistener
    public void setMlistener(OnItemClickListener mlistener) {
        this.mlistener = mlistener;
    }

    //Función para la creación del holder
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_projecto,parent,false);
        Holder holder = new Holder(view,mlistener);
        return holder;
    }

    //Método para el llamado del método connectData
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.connectData(cProjectList.get(position));
    }

    //Método para mostrar un número determidado de items
    @Override
    public int getItemCount() {
        return cProjectList.size();
    }

    //Clase interna llamada Holder
    public class Holder extends RecyclerView.ViewHolder {
        //Declaración del view txtProjecto
        TextView txtProjecto = itemView.findViewById(R.id.txtProjecto);
        //Constructor para la utilización del Holder
        public Holder(View itemView, final OnItemClickListener mlistener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mlistener!=null){
                        int position = getLayoutPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mlistener.itemClick(position);
                        }
                    }
                }
            });
        }

        //Método para el ingreso de datos al item
        public void connectData(CProject project){
            txtProjecto.setText(project.getNombre());
        }
    }
}
