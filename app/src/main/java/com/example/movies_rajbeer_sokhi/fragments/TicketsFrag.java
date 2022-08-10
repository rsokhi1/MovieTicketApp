package com.example.movies_rajbeer_sokhi.fragments;

import android.graphics.Movie;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies_rajbeer_sokhi.R;
import com.example.movies_rajbeer_sokhi.databinding.FragmentTicketsBinding;
import com.example.movies_rajbeer_sokhi.models.MovieResponsObject;
import com.example.movies_rajbeer_sokhi.network.API;
import com.example.movies_rajbeer_sokhi.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketsFrag extends Fragment {
    private FragmentTicketsBinding binding;

    public TicketsFrag(){
        super(R.layout.fragment_tickets);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstance){
        binding = FragmentTicketsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}