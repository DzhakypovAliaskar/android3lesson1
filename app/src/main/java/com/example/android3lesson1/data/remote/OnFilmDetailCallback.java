package com.example.android3lesson1.data.remote;

import com.example.android3lesson1.ui.models.Film;

public interface OnFilmDetailCallback {
    void success(Film film);
    void serverError();
    void failure(String msg);
}
