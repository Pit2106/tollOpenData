package com.pruebas.peajeopendata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.pruebas.peajeopendata.Models.Toll;

import java.util.ArrayList;

public class TollView extends AppCompatActivity {

    private TextView tvName, tvProject, tvDepartament, tvTown;
    private ListView lvFares;
    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toll_view);

        // Link
        tvName = findViewById(R.id.tvName);
        tvProject = findViewById(R.id.tvProject);
        tvDepartament = findViewById(R.id.tvDepartament);
        tvTown = findViewById(R.id.tvTown);

        lvFares  = findViewById(R.id.lvFares);

        btBack = findViewById(R.id.btBack);

        //Toll Data
        Bundle extras = getIntent().getExtras();
        Toll t= (Toll) extras.getSerializable("toll");

        loadData(t);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void loadData(Toll t){
        tvName.setText(t.getNombreestacionpeaje());
        tvProject.setText(t.getNombreproyecto());
        tvDepartament.append(t.getDepartamento());
        tvTown.append(t.getMunicipio());

        ArrayList<String> fears = new ArrayList<>();

        if (t.getI().charAt(t.getI().length()-1)!='-')         fears.add("Tarifa Plena I:"+t.getI());
        if (t.getIi().charAt(t.getIi().length()-1)!='-')       fears.add("Tarifa Plena II:"+t.getIi());
        if (t.getIii().charAt(t.getIii().length()-1)!='-')       fears.add("Tarifa Plena III:"+t.getIii());
        if (t.getIv().charAt(t.getIv().length()-1)!='-')       fears.add("Tarifa Plena IV:"+t.getIv());
        if (t.getV().charAt(t.getV().length()-1)!='-')       fears.add("Tarifa Plena V:"+t.getV());
        if (t.getVi().charAt(t.getVi().length()-1)!='-')       fears.add("Tarifa Plena VI:"+t.getVi());
        if (t.getVii().charAt(t.getVii().length()-1)!='-')       fears.add("Tarifa Plena VII:"+t.getVii());
        if (t.getViii().charAt(t.getViii().length()-1)!='-')       fears.add("Tarifa Plena VIII:"+t.getViii());
        if (t.getIx().charAt(t.getIx().length()-1)!='-')       fears.add("Tarifa Plena IX:"+t.getIx());
        if (t.getIe().charAt(t.getIe().length()-1)!='-')       fears.add("Tarifa Plena IE10:"+t.getIe());
        if (t.getIee().charAt(t.getIee().length()-1)!='-')       fears.add("Tarifa Plena IEE:"+t.getIee());
        if (t.getIeee().charAt(t.getIeee().length()-1)!='-')       fears.add("Tarifa Plena IEEE:"+t.getIeee());
        if (t.getIia().charAt(t.getIia().length()-1)!='-')       fears.add("Tarifa Plena IIA:"+t.getIia());
        if (t.getEa().charAt(t.getEa().length()-1)!='-')       fears.add("Tarifa Plena E.A."+t.getEa());
        if (t.getEg().charAt(t.getEg().length()-1)!='-')       fears.add("Tarifa Plena E.G."+t.getEg());
        if (t.getTar_plena_e_r().charAt(t.getTar_plena_e_r().length()-1)!='-')       fears.add("Tarifa Plena E.R."+t.getTar_plena_e_r());
        if (t.getEc().charAt(t.getEc().length()-1)!='-')       fears.add("Tarifa Plena E.C."+t.getEc());
        if (t.getTar_especial_i().charAt(t.getTar_especial_i().length()-1)!='-')       fears.add("Tarifa Especial I"+t.getTar_especial_i());
        if (t.getIie().charAt(t.getIie().length()-1)!='-')       fears.add("Tarifa Especial II"+t.getIie());
        if (t.getIiie().charAt(t.getIiie().length()-1)!='-')       fears.add("Tarifa Especial III"+t.getIiie());
        if (t.getIve().charAt(t.getIve().length()-1)!='-')       fears.add("Tarifa Especial IV"+t.getIve());
        if (t.getVe().charAt(t.getVe().length()-1)!='-')       fears.add("Tarifa Especial V"+t.getVe());
        if (t.getTar_especial_vi().charAt(t.getTar_especial_vi().length()-1)!='-')       fears.add("Tarifa Especial VI"+t.getTar_especial_vi());
        if (t.getTar_especial_vii().charAt(t.getTar_especial_vii().length()-1)!='-')       fears.add("Tarifa Especial VII"+t.getTar_especial_vii());
        if (t.getTar_especial_viii().charAt(t.getTar_especial_viii().length()-1)!='-')       fears.add("Tarifa Especial VIII"+t.getTar_especial_viii());
        if (t.getTar_especial_ix().charAt(t.getTar_especial_ix().length()-1)!='-')       fears.add("Tarifa Especial IX"+t.getTar_especial_ix());
        if (t.getTar_especial_ie_10().charAt(t.getTar_especial_ie_10().length()-1)!='-')       fears.add("Tarifa Especial IE10"+t.getTar_especial_ie_10());
        if (t.getTar_especial_iee().charAt(t.getTar_especial_iee().length()-1)!='-')       fears.add("Tarifa Especial IEE"+t.getTar_especial_iee());
        if (t.getTar_especial_ieee().charAt(t.getTar_especial_ieee().length()-1)!='-')       fears.add("Tarifa Especial IEEE"+t.getTar_especial_ieee());
        if (t.getTar_especial_iia().charAt(t.getTar_especial_iia().length()-1)!='-')       fears.add("Tarifa Especial IIA"+t.getTar_especial_iia());
        if (t.getEae().charAt(t.getEae().length()-1)!='-')       fears.add("Tarifa Especial EAE"+t.getEae());
        if (t.getTar_especial_e_g().charAt(t.getTar_especial_e_g().length()-1)!='-')       fears.add("Tarifa Especial E.G."+t.getTar_especial_e_g());
        if (t.getTar_especial_e_r().charAt(t.getTar_especial_e_r().length()-1)!='-')       fears.add("Tarifa Especial E.R."+t.getTar_especial_e_r());
        if (t.getTar_especial_e_c().charAt(t.getTar_especial_e_c().length()-1)!='-')       fears.add("Tarifa Especial E.C."+t.getTar_especial_e_c());

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,fears);
        lvFares.setAdapter(adapter);
    }
}
