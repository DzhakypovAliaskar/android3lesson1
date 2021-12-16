package com.example.android3lesson1.data.remote;

import androidx.annotation.NonNull;

import com.example.android3lesson1.databinding.FragmentFilmDetailBinding;
import com.example.android3lesson1.ui.App;
import com.example.android3lesson1.ui.models.Film;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiService {


    public void getFilms(OnFilmReadyCallback myCallback){

        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(@NonNull Call<List<Film>> call, @NonNull Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null){
                    myCallback.success(response.body());
                }else if (response.code() > 500){
                    myCallback.onServerError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Film>> call, @NonNull Throwable t) {
                myCallback.failure(t.getLocalizedMessage());
            }
        });
    }

    public void getDetailFilms(String id, OnFilmDetailCallback detailCallback){
        App.api.getDetailFilms(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(@NonNull Call<Film> call, @NonNull Response<Film> response) {
                if (response.isSuccessful() && response.body() != null){
                    detailCallback.success(response.body());
                }
                else if (response.code() > 500){
                    detailCallback.serverError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Film> call, @NonNull Throwable t) {
                detailCallback.failure(t.getLocalizedMessage());
            }
        });
    }
}