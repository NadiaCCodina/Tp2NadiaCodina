package com.nadia.tp2nadiacodina;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nadia.tp2nadiacodina.modelos.Libro;

import java.util.Arrays;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private List<Libro> listaLibros = Arrays.asList(
            new Libro("Despierta","1234","Anthony De Melo", "Mundo", "Es un super libro", "Autoayuda", 2010, 100),
            new Libro("El dia que Nietsche lloró","5678","Louis Vilton", "Campana", "alta historia", "Drama", 2005, 302),
            new Libro("Un Mundo Feliz","9123","Aldous Houxley", "Banana", "Una critica al mundo moderno", "Ciencia ficción", 2013, 235));


    private MutableLiveData<String> mutableError = new MutableLiveData<>();

    public MainActivityViewModel(android.app.Application application) {
        super(application);
    }
    public void buscarLibro(String titulo){
        boolean encontrado = false;
        for (Libro libro : listaLibros
        ) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                Intent intentLibro = new Intent(getApplication(), LibroEncontradoActivity.class);
                intentLibro.putExtra("Libro encontrado", libro);
                intentLibro.setFlags(intentLibro.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intentLibro);
                encontrado =true;
                    break;}}
            if(!encontrado){
                mutableError.setValue("No se encontró el libro");
            }

    }

    public LiveData<String > getMutableError() {
        if (mutableError==null)
            mutableError = new MutableLiveData<>();
        return mutableError;
    }

}