package com.example.apppractica;

public class Heroe {
    private String nombre;
    private String poder;

    public Heroe(String nombre, String poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPoder() {
        return poder;
    }
}
