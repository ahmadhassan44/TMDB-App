package com.example.testtask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testtask.Models.MovieModel;
import com.example.testtask.R;
import com.example.testtask.ViewModels.SearchViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    List<MovieModel> searchResults;

    public void setSearchResults(List<MovieModel> searchResults) {
        this.searchResults = searchResults;
        notifyDataSetChanged();
    }

    public SearchAdapter(List<MovieModel> searchResults)
    {
        this.searchResults=searchResults;
    }
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.searchitem,parent,false);
        return new SearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        MovieModel model=searchResults.get(position);
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" + model.getPoster_path())
                .error(R.drawable.baseline_error_24)
                .into(holder.poster);
        holder.title.setText(model.getTitle());
        holder.overview.setText(model.getOverview());
    }
    @Override
    public int getItemCount() {
        return searchResults.size();
    }
    public class SearchViewHolder extends RecyclerView.ViewHolder{
        ImageView poster;
        TextView title;
        TextView overview;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            poster=itemView.findViewById(R.id.imageView5);
            title=itemView.findViewById(R.id.textView3);
            overview=itemView.findViewById(R.id.textView7);
        }
    }
}
