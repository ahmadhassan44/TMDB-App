package com.example.testtask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtask.Models.GenreModel;
import com.example.testtask.R;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {
    List<GenreModel>genres;
    public GenreAdapter(List<GenreModel> genres)
    {
        this.genres=genres;
    }
    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.genreitem,parent,false);
        return new GenreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        GenreModel genreModel=genres.get(position);
        holder.genre.setText(genreModel.getName());
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public void setGenres(List<GenreModel> genreModels) {
        genres=genreModels;
        notifyDataSetChanged();
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder{
        TextView genre;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            genre=itemView.findViewById(R.id.textView6);
        }
    }
}
