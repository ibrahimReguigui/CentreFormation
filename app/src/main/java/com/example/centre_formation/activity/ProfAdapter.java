package com.example.centre_formation.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.centre_formation.R;
import com.example.centre_formation.entity.Prof;

import java.util.List;

public class ProfAdapter extends RecyclerView.Adapter<ProfAdapter.ViewHolder> {

    private List<Prof> profList;

    public ProfAdapter(List<Prof> profList) {
        this.profList = profList;
    }
    interface OnProfDeleteListener {
        void onDeleteProf(Prof prof);
    }
    public void deleteProf(int position) {
        profList.remove(position);
        notifyItemRemoved(position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prof_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Prof prof = profList.get(position);
        holder.nameTextView.setText(prof.getNom());
        // Set other properties as needed
    }

    @Override
    public int getItemCount() {
        return profList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        // Other views in your layout
        private Button deleteButton;
        private Button updateButton;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_view_name);
            deleteButton = itemView.findViewById(R.id.btn_delete_prof);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {

                        ((ProfListActivity) itemView.getContext()).onDeleteProf(getAdapterPosition());
                    }
                }
            });
            updateButton = itemView.findViewById(R.id.btn_update_prof);
            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                        // Assuming you have a method in your activity to handle the update
                        ((ProfListActivity) itemView.getContext()).onUpdateProf(getAdapterPosition());
                    }
                }
            });

        }
    }
}
