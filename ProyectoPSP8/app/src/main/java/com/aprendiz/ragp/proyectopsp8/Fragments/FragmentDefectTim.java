package com.aprendiz.ragp.proyectopsp8.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aprendiz.ragp.proyectopsp8.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDefectTim extends Fragment {


    public FragmentDefectTim() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_defect_tim, container, false);
    }

}