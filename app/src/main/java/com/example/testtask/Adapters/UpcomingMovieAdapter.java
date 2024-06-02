package com.example.testtask.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testtask.Activities.MovieDetailsActivity;
import com.example.testtask.R;
import com.example.testtask.RoomDatabase.Movie;

import java.util.List;

public class UpcomingMovieAdapter extends RecyclerView.Adapter<UpcomingMovieAdapter.MovieViewHolder>{

    private List<Movie> movies;
    private Context context;
    public UpcomingMovieAdapter(List<Movie> movies,Context context) {
        this.movies = movies;
        this.context=context;
    }

    @NonNull
    @Override
    public UpcomingMovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homemovieitem, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingMovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" + movie.getBackdrop_path())
                .error(R.drawable.baseline_error_24)
                .into(holder.backdrop);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("movieid",movie.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> list) {
        movies=list;
        notifyDataSetChanged();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView backdrop;
        TextView title;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            backdrop=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.textView2);
        }
    }
}
