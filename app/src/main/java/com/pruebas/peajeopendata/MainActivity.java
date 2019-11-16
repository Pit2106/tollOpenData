package com.pruebas.peajeopendata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pruebas.peajeopendata.Models.Toll;
import com.pruebas.peajeopendata.openDataAPI.OpenDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String BASEURL = "https://www.datos.gov.co/resource/";
    private static final String TAG = "TOLL";

    private RecyclerView recyclerView;
    private int offset;
    private boolean enableLoad;
    TollsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        offset=0;

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new TollsListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager manager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0){
                    int visibleItemCount = manager.getChildCount();
                    int totalItemContent = manager.getItemCount();
                    int pasVisibleItems = manager.findFirstVisibleItemPosition();

                    if(enableLoad){
                        if(visibleItemCount + pasVisibleItems >= totalItemContent){
                            enableLoad = false;
                            offset+=20;
                            getData(offset);
                        }
                    }
                }
            }
        });

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Toll> ts = adapter.getTolls();

                Intent intent = new Intent(MainActivity.this,TollView.class);
                Bundle b = new Bundle();
                b.putSerializable("toll",ts.get(recyclerView.getChildAdapterPosition(view)));
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        enableLoad = true;

        retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        getData(offset);
    }

    private void getData(int offset){
        OpenDataService service = retrofit.create(OpenDataService.class);
        Call<List<Toll>> openResponseCall = service.getDataList(20, offset);

        openResponseCall.enqueue(new Callback<List<Toll>>() {
            @Override
            public void onResponse(Call<List<Toll>> call, Response<List<Toll>> response) {
                enableLoad = true;
                if(response.isSuccessful()){
                    List<Toll> tolls = response.body();
                    ArrayList<Toll> arrayTolls = new ArrayList<>();
                    for(Toll t: tolls){
                        arrayTolls.add(t);
                    }

                    adapter.addList(arrayTolls);

                }else{
                    Log.e(TAG,"onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Toll>> call, Throwable t) {
                enableLoad = true;
                Log.e(TAG,"onFailure: " + t.getMessage());
            }
        });

    }
}
/*
openResponseCall.enqueue(new Callback<OpenResponse>() {
            @Override
            public void onResponse(Call<OpenResponse> call, Response<OpenResponse> response) {
                if(response.isSuccessful()){

                    OpenResponse or = response.body();
                    or.setPeajeList((ArrayList<Toll>)or.getStarter().get(0));
                    ArrayList<Toll> tolls = or.getPeajeList();
                    for(int i=0;i<tolls.size();i++){
                        Toll t = tolls.get(i);
                        Log.i(TAG, "Peaje: " + t.getNombreestacionpeaje());
                    }
                }else{
                    Log.e(TAG,"onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<OpenResponse> call, Throwable t) {
                Log.e(TAG,"onFailure: " + t.getMessage());
            }
        });

          List<Toll> tolls = response.body();
                for(Toll t: tolls){
                    Log.i(TAG, "Peaje: " + t.getNombreestacionpeaje());
                }
 */