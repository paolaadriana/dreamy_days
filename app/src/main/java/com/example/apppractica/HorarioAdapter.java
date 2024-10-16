package com.example.apppractica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder> {

    private List<Horario> horarios;
    private OnItemClickListener onItemClickListener;

    public HorarioAdapter(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @NonNull
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horario, parent, false);
        return new HorarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder holder, int position) {
        Horario horario = horarios.get(position);
        holder.horaTextView.setText(horario.getHora());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(horario);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return horarios.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Horario horario);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public static class HorarioViewHolder extends RecyclerView.ViewHolder {
        TextView horaTextView;

        public HorarioViewHolder(@NonNull View itemView) {
            super(itemView);
            horaTextView = itemView.findViewById(R.id.horaTextView);
        }
    }
}
