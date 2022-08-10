package com.example.movies_rajbeer_sokhi.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies_rajbeer_sokhi.R;
import com.example.movies_rajbeer_sokhi.adapters.MoviesAdapter;
import com.example.movies_rajbeer_sokhi.databinding.FragmentNowPlayingBinding;
import com.example.movies_rajbeer_sokhi.models.Movies;
import com.example.movies_rajbeer_sokhi.models.MovieResponsObject;
import com.example.movies_rajbeer_sokhi.network.API;
import com.example.movies_rajbeer_sokhi.network.RetrofitClient;
import com.example.movies_rajbeer_sokhi.singleton.MoviesSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NowPlayingFrag extends Fragment {
    private FragmentNowPlayingBinding binding;
//    private ArrayList<Movies> moviesList = new ArrayList<>();
    private MoviesAdapter adapter;
    private MoviesSingleton moviesList;

    private API api;
    public NowPlayingFrag(){
        super(R.layout.fragment_now_playing);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = RetrofitClient.getInstance().getApi();
        Log.d("ABC", "onViewCreated: ");
        moviesList = MoviesSingleton.getInstance();


//
        MoviesAdapter adapter = new MoviesAdapter(view.getContext(), moviesList.getMovieList());
        binding.rvMovies.setLayoutManager(new LinearLayoutManager(view.getContext()));
        binding.rvMovies.setAdapter(adapter);
        adapter.notifyDataSetChanged();
//
//        ArrayList<Movies> list = moviesList.getMovieList();
//
//        for (int i = 0;i<moviesList.getMovieList().size();i++){
//            Log.d("ABC", list.get(i).toString());
//        }
//        Log.d("ABC", "RecyclerView Created: ");


//        Call<MovieResponsObject> response = api.getAllMovies();
//        response.enqueue(new Callback<MovieResponsObject>() {
//            @Override
//            public void onResponse(Call<MovieResponsObject> call, Response<MovieResponsObject> response) {
//                if (response.isSuccessful() == false){
//                    Log.d("ABC", "Error from API: " + response.code());
//                }
//                MovieResponsObject obj = response.body();
//                moviesList = obj.getResults();
//                for(int i = 0;i<obj.getResults().size();i++){
//                    Log.d("ABC", obj.getResults().get(i).toString());
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponsObject> call, Throwable t) {
//                Log.d("ABC",t.getMessage());
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstance){
        binding = FragmentNowPlayingBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
//        adapter = new MoviesAdapter(view.getContext(), moviesList.getMovieList());
//        binding.rvMovies.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        binding.rvMovies.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}