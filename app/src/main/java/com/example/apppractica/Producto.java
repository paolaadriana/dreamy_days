package com.example.apppractica;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable {
    private String nombre;
    private String categoria;
    private String temporada;
    private double precioCompra;
    private double precioVenta;

    public Producto(String nombre, String categoria, String temporada, double precioCompra, double precioVenta) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.temporada = temporada;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    protected Producto(Parcel in) {
        nombre = in.readString();
        categoria = in.readString();
        temporada = in.readString();
        precioCompra = in.readDouble();
        precioVenta = in.readDouble();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(categoria);
        dest.writeString(temporada);
        dest.writeDouble(precioCompra);
        dest.writeDouble(precioVenta);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTemporada() {
        return temporada;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
}
