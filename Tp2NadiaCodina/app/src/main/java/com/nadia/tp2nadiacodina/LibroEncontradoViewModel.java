package com.nadia.tp2nadiacodina;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nadia.tp2nadiacodina.modelos.Libro;

public class LibroEncontradoViewModel extends AndroidViewModel {
private MutableLiveData<Libro> libroMutable;

    public LiveData<Libro> getLibroMutable() {
        if( libroMutable==null){
            libroMutable = new MutableLiveData<>();
        }
        return libroMutable;
    };

    public LibroEncontradoViewModel(@NonNull Application application) {
        super(application);
    }

    public void LeerLibro(Intent libroIntent) {
        Libro libro;
            libro = libroIntent.getSerializableExtra("Libro encontrado", Libro.class);
            libroMutable.setValue(libro);

    }

}
