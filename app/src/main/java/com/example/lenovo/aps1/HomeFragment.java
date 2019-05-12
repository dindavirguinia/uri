package com.example.lenovo.aps1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private CardView aggCard, jadwalCard, medaliCard, organisasiCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        aggCard = (CardView) v.findViewById(R.id.agg_card);
        jadwalCard = (CardView) v.findViewById(R.id.jadwal_card);
        medaliCard = (CardView) v.findViewById(R.id.medali_card);
        organisasiCard = (CardView) v.findViewById(R.id.organisasi_card);

        //Add Click Listener to the cards
        aggCard.setOnClickListener(this);
        jadwalCard.setOnClickListener(this);
        medaliCard.setOnClickListener(this);
        organisasiCard.setOnClickListener(this);

        return v;

    }


    @Override
    public void onClick(View v) {
        Intent i ;

        switch (v.getId()){
            case R.id.agg_card : i = new Intent(getActivity(),Anggota.class);startActivity(i); break;
            case R.id.jadwal_card : i = new Intent(getActivity(), Jadwal.class);startActivity(i); break;
            case R.id.medali_card : i = new Intent(getActivity(), Prestasi.class);startActivity(i); break;
            case R.id.organisasi_card : i = new Intent(getActivity(), Organisasi.class);startActivity(i); break;
            default:break;
        }
    }
}
