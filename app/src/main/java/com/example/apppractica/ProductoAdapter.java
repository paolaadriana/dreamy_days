package com.example.apppractica;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private Context context;
    private ArrayList<Producto> productos;

    public ProductoAdapter(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productos.get(position);

        // Configura los elementos de la vista
        if (producto.getCategoria().equals("Frutas")) {
            holder.tvCategoria.setText("F");
            holder.tvCategoria.setBackgroundColor(ContextCompat.getColor(context, R.color.colorFrutas));
        } else {
            holder.tvCategoria.setText("V");
            holder.tvCategoria.setBackgroundColor(ContextCompat.getColor(context, R.color.colorVerduras));
        }

        holder.tvNombreLabel.setText("Producto:");
        holder.tvNombre.setText(producto.getNombre());

        holder.tvPrecioVenta.setText(String.format("%.2f", producto.getPrecioVenta()));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoria;
        TextView tvNombreLabel;
        TextView tvNombre;
        TextView tvPrecioVenta;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoria = itemView.findViewById(R.id.tvCategoria);
            tvNombreLabel = itemView.findViewById(R.id.tvNombreLabel);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPrecioVenta = itemView.findViewById(R.id.tvPrecioVenta);
        }
    }
}
