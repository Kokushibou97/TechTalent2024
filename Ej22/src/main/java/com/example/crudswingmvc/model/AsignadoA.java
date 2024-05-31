package com.example.crudswingmvc.model;

public class AsignadoA {
    private String cientificoDni;
    private String proyectoId;

    public AsignadoA(String cientificoDni, String proyectoId) {
        this.cientificoDni = cientificoDni;
        this.proyectoId = proyectoId;
    }

    public String getCientificoDni() {
        return cientificoDni;
    }

    public void setCientificoDni(String cientificoDni) {
        this.cientificoDni = cientificoDni;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }
}
