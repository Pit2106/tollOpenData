package com.pruebas.peajeopendata.Models;

import com.pruebas.peajeopendata.Models.Toll;

import java.util.ArrayList;

public class OpenResponse {
    private ArrayList starter;
    private ArrayList<Toll> peajeList;

    public OpenResponse(ArrayList starter) {
        this.starter = starter;
        peajeList = (ArrayList<Toll>) this.starter.get(0);
    }

    public ArrayList getStarter() {
        return starter;
    }

    public void setStarter(ArrayList starter) {
        this.starter = starter;
    }

    public ArrayList<Toll> getPeajeList() {
        return peajeList;
    }

    public void setPeajeList(ArrayList<Toll> peajeList) {
        this.peajeList = peajeList;
    }
}
