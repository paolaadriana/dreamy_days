package com.example.apppractica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MedicoAdapter extends RecyclerView.Adapter<MedicoAdapter.MedicoViewHolder> {

    private final List<Medico> medicoList;
    private final OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Medico medico);
    }

    public MedicoAdapter(List<Medico> medicoList, OnItemClickListener onItemClickListener) {
        this.medicoList = medicoList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MedicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medico, parent, false);
        return new MedicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicoViewHolder holder, int position) {
        Medico medico = medicoList.get(position);
        holder.nombreTextView.setText(medico.getNombre());
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(medico));
    }

    @Override
    public int getItemCount() {
        return medicoList.size();
    }

    public static class MedicoViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreTextView;

        public MedicoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.medicoNameTextView);
        }
    }
}
