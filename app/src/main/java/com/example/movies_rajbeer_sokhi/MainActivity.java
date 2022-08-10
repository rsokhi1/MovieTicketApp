package com.example.movies_rajbeer_sokhi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;

import com.example.movies_rajbeer_sokhi.databinding.ActivityMainBinding;
import com.example.movies_rajbeer_sokhi.models.MovieResponsObject;
import com.example.movies_rajbeer_sokhi.network.API;
import com.example.movies_rajbeer_sokhi.network.RetrofitClient;
import com.example.movies_rajbeer_sokhi.singleton.MoviesSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MoviesSingleton moviesList;
    private API api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavController navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(binding.bottomMenu,navController);
        moviesList = MoviesSingleton.getInstance();

        api = RetrofitClient.getInstance().getApi();

        Call<MovieResponsObject> response = api.getAllMovies();
        response.enqueue(new Callback<MovieResponsObject>() {
            @Override
            public void onResponse(Call<MovieResponsObject> call, Response<MovieResponsObject> response) {
                if(response.isSuccessful() == false){
                    Log.d("ABC", "Error from API: " + response.code());
                }
                MovieResponsObject obj = response.body();
                moviesList.setMovieList(obj.getResults());

//                for(int i = 0;i<obj.getResults().size();i++){
//                    Log.d("ABC", obj.getResults().get(i).toString());
//                }
            }

            @Override
            public void onFailure(Call<MovieResponsObject> call, Throwable t) {
                Log.d("ABC",t.getMessage());
            }
        });






    }
}