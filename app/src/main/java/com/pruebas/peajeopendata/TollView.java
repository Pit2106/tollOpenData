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

        fears.add("Tarifa Plena I:"+t.getI());
        fears.add("Tarifa Plena II:"+t.getIi());
        fears.add("Tarifa Plena III:"+t.getIii());
        fears.add("Tarifa Plena IV:"+t.getIv());
        fears.add("Tarifa Plena V:"+t.getV());
        fears.add("Tarifa Plena VI:"+t.getVi());
        fears.add("Tarifa Plena VII:"+t.getVii());
        fears.add("Tarifa Plena VIII:"+t.getViii());
        fears.add("Tarifa Plena IX:"+t.getIx());
        fears.add("Tarifa Plena IE10:"+t.getIe());
        fears.add("Tarifa Plena IEE:"+t.getIee());
        fears.add("Tarifa Plena IEEE:"+t.getIeee());
        fears.add("Tarifa Plena IIA:"+t.getIia());
        fears.add("Tarifa Plena E.A."+t.getEa());
        fears.add("Tarifa Plena E.G."+t.getEg());
        fears.add("Tarifa Plena E.R."+t.getTar_plena_e_r());
        fears.add("Tarifa Plena E.C."+t.getEc());
        fears.add("Tarifa Especial I"+t.getTar_especial_i());
        fears.add("Tarifa Especial II"+t.getIie());
        fears.add("Tarifa Especial III"+t.getIiie());
        fears.add("Tarifa Especial IV"+t.getIve());
        fears.add("Tarifa Especial V"+t.getVe());
        fears.add("Tarifa Especial VI"+t.getTar_especial_vi());
        fears.add("Tarifa Especial VII"+t.getTar_especial_vii());
        fears.add("Tarifa Especial VIII"+t.getTar_especial_viii());
        fears.add("Tarifa Especial IX"+t.getTar_especial_ix());
        fears.add("Tarifa Especial IE10"+t.getTar_especial_ie_10());
        fears.add("Tarifa Especial IEE"+t.getTar_especial_iee());
        fears.add("Tarifa Especial IEEE"+t.getTar_especial_ieee());
        fears.add("Tarifa Especial IIA"+t.getTar_especial_iia());
        fears.add("Tarifa Especial EAE"+t.getEae());
        fears.add("Tarifa Especial E.G."+t.getTar_especial_e_g());
        fears.add("Tarifa Especial E.R."+t.getTar_especial_e_r());
        fears.add("Tarifa Especial E.C."+t.getTar_especial_e_c());

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,fears);
        lvFares.setAdapter(adapter);
    }
}
