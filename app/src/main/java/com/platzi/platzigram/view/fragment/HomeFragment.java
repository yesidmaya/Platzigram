package com.platzi.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.platzigram.R;
import com.platzi.platzigram.adapter.PictureAdapterRecyclerView;
import com.platzi.platzigram.modelo.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    // el fragment va a estar inscrustado como si fuera una view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // el view que va a crear es
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // vamos a mostrar el showtoolbar
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        // instanciamos RecyclerView
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);
        // vamos a darle forma con linearlayoutmanager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()); // lo obtengo el contexto
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // luego al contexto le coloco propiedades

        // linearLayoutManager contiene la orientacion y la forma de mostrar las tar
        picturesRecycler.setLayoutManager(linearLayoutManager);

        // colocamos nuestro adapter. creamos el objeto
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture,getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;

    }

    // metodo que nos devuelva un arreglo
    public ArrayList<Picture> buidPictures(){
        // lo que devolveremos
        ArrayList<Picture> pictures = new ArrayList<>();
        // agregamos las pictures
        pictures.add(new Picture("https://s-media-cache-ak0.pinimg.com/originals/9f/26/80/9f26808c61574d97b826e6a8905e7272.jpg","Uriel Ramirez","3 Días","23 Me Gusta"));

        pictures.add(new Picture("https://i.pinimg.com/originals/9f/c5/18/9fc518ac6dc27de74448324b2a389c48.jpg","Juan Pablo Ramirez","5 Días","13 Me Gusta"));
        pictures.add(new Picture("http://www.ensiibague.edu.co/portalnew/wp-content/uploads/2015/05/Paisajes-Bonitos-Atardecer-12.jpg","Luis Lopez","7 Días","43 Me Gusta"));
        pictures.add(new Picture("https://static.panoramio.com.storage.googleapis.com/photos/large/5046641.jpg","Zuleima","4 Días","13 Me Gusta"));
        pictures.add(new Picture("http://www.viajesgeotours.com/images/portafolio/imagen_id_6365.jpg","Carlos Ramirez","4 Días","73 Me Gusta"));
        return pictures;
    }

    // trabajamos el toolbar el cual copiamos de CreateAccountActivity y le realizamos unos cambios
    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar); // ((AppCompatActivity) getActivity()). estas dos lineas son importantes para que el toolbar tenga soporte para verciones anteriores
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); // en caso de que tenga boton de regreso o boton de subir
        // y habilitamos que el boton de back sea visble
    }

}
