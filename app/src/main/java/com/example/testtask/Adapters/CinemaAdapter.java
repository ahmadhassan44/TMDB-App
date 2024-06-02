package com.example.testtask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtask.R;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CinemaHolder> {
    @NonNull
    @Override
    public CinemaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cinemaitem,parent,false);
        return new CinemaHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaHolder holder, int position) {
    }
    @Override
    public int getItemCount() {
        return 6;
    }
    public class CinemaHolder extends RecyclerView.ViewHolder
    {
        public CinemaHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
