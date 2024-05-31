package com.example.crudswingmvc.model;

public class Cientific {
	private String dni;
    private String nombreApellidos;

    public Cientific(String dni, String nombreApellidos) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }
}
