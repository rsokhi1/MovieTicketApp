package com.example.movies_rajbeer_sokhi.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies_rajbeer_sokhi.databinding.MovieLayoutBinding;
import com.example.movies_rajbeer_sokhi.models.Movies;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ItemViewHolder> {

    private final Context context;
    private final ArrayList<Movies> moviesList;
    MovieLayoutBinding binding;



    public MoviesAdapter(Context context, ArrayList<Movies> items){
        this.moviesList = items;
        this.context = context;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        MovieLayoutBinding itemBinding;
        public ItemViewHolder(MovieLayoutBinding binding) {
            super(binding.getRoot());
            // Define click listener for the ViewHolder's View
            this.itemBinding = binding;
        }

        public void bind(Context context, Movies currentItem){
            // TODO: Update the UI for the row
            itemBinding.tvTitle.setText(currentItem.getTitle());
            itemBinding.tvReleaseDate.setText(currentItem.getRelease_date());
            itemBinding.tvOverview.setText(currentItem.getOverview());

            Glide.with(context).load("https://image.tmdb.org/t/p/w500"+currentItem.getPoster_path()).into(itemBinding.ivPoster);


        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        return new ItemViewHolder(MovieLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ItemViewHolder viewHolder, final int position) {

        Movies currentItem = moviesList.get(position);
        viewHolder.bind(context,currentItem);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        Log.d("CharacterAdapter","GetItemCount: Number of items " + this.moviesList.size());
        return this.moviesList.size();
    }

}
