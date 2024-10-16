package com.example.apppractica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EspecialidadAdapter extends RecyclerView.Adapter<EspecialidadAdapter.EspecialidadViewHolder> {

    private final List<Especialidad> especialidadList;
    private final OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Especialidad especialidad);
    }

    public EspecialidadAdapter(List<Especialidad> especialidadList, OnItemClickListener onItemClickListener) {
        this.especialidadList = especialidadList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public EspecialidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_especialidad, parent, false);
        return new EspecialidadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EspecialidadViewHolder holder, int position) {
        Especialidad especialidad = especialidadList.get(position);
        holder.nombreTextView.setText(especialidad.getNombre());
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(especialidad));
    }

    @Override
    public int getItemCount() {
        return especialidadList.size();
    }

    public static class EspecialidadViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreTextView;

        public EspecialidadViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.especialidadNameTextView);
        }
    }
}
