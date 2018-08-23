package com.aprendiz.ragp.proyectopsp8.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aprendiz.ragp.proyectopsp8.MenuPrincipal;
import com.aprendiz.ragp.proyectopsp8.Models.AdapterR;
import com.aprendiz.ragp.proyectopsp8.Models.ManagerDB;
import com.aprendiz.ragp.proyectopsp8.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDefectTim extends Fragment {

    RecyclerView recyclerView;

    public FragmentDefectTim() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_defect_tim, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        inputAdapter();
        return view;
    }

    private void inputAdapter() {
        ManagerDB managerDB = new ManagerDB(getContext());
        AdapterR adapterR = new AdapterR(managerDB.defectsInjectInPhase(MenuPrincipal.project.getId()));
        recyclerView.setAdapter(adapterR);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);

    }

}
