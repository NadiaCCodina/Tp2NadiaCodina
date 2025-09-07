package com.nadia.tp2nadiacodina;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nadia.tp2nadiacodina.databinding.ActivityLibroEncontradoBinding;
import com.nadia.tp2nadiacodina.modelos.Libro;

public class LibroEncontradoActivity extends AppCompatActivity {
private ActivityLibroEncontradoBinding bindingLibro;
private LibroEncontradoViewModel levm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingLibro = ActivityLibroEncontradoBinding.inflate(getLayoutInflater());
        levm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LibroEncontradoViewModel.class);
        setContentView((bindingLibro.getRoot()));

        levm.getLibroMutable().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                bindingLibro.tvTitulo.setText(libro.getTitulo());
                bindingLibro.tvAutor.setText(libro.getAutor());
                bindingLibro.tvEditorial.setText(libro.getEditorial());

            }
        });
        levm.LeerLibro(getIntent());

    }
}