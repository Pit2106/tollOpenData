package com.pruebas.peajeopendata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pruebas.peajeopendata.Models.Toll;

import java.util.ArrayList;

public class TollsListAdapter extends RecyclerView.Adapter<TollsListAdapter.ViewHolder>
                    implements View.OnClickListener {

    private ArrayList<Toll> tolls;
    private View.OnClickListener listener;
    public TollsListAdapter(){
        tolls=new ArrayList<Toll>();
    }

    public ArrayList<Toll> getTolls() {
        return tolls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_toll, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Toll t = tolls.get(position);
        holder.tollName.setText(t.getNombreestacionpeaje());
        holder.tollProject.setText(t.getNombreproyecto());
    }

    @Override
    public int getItemCount() {
        return tolls.size();
    }

    public void addList(ArrayList<Toll> arrayTolls) {

        tolls.addAll(arrayTolls);
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tollName, tollProject;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tollName = itemView.findViewById(R.id.tvTollName);
            tollProject = itemView.findViewById(R.id.tvTollProject);
        }
    }
}
