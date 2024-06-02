    package com.example.testtask.Fragments;

    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ProgressBar;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;
    import androidx.lifecycle.Observer;
    import androidx.lifecycle.ViewModel;
    import androidx.lifecycle.ViewModelProvider;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.testtask.Adapters.UpcomingMovieAdapter;
    import com.example.testtask.R;
    import com.example.testtask.RoomDatabase.Movie;
    import com.example.testtask.Starters.NetworkCheck;
    import com.example.testtask.ViewModels.MoviesListViewModel;

    import java.util.ArrayList;
    import java.util.List;

    public class HomeFragment extends Fragment {
        RecyclerView recview;
        private View HomeFragment;
        private ProgressBar bar;

        private MoviesListViewModel mViewModel;

        public static HomeFragment newInstance() {
            return new HomeFragment();
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            HomeFragment= inflater.inflate(R.layout.fragment_home, container, false);
            return HomeFragment;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            recview=HomeFragment.findViewById(R.id.recview);
            mViewModel=new ViewModelProvider(this).get(MoviesListViewModel.class);
            if (new NetworkCheck().isNetworkAvailable(getContext())) {
                mViewModel.refreshMovies();
            }
            UpcomingMovieAdapter adapter=new UpcomingMovieAdapter(new ArrayList<>(),getContext());
            recview.setLayoutManager(new LinearLayoutManager(getContext()));
            recview.setAdapter(adapter);
            mViewModel.getMovies().observe(getViewLifecycleOwner(), new Observer<List<Movie>>() {
                @Override
                public void onChanged(List<Movie> list) {
                    adapter.setMovies(list);
                }
            });
        }
    }
