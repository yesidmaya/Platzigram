package com.platzi.platzigram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.platzi.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_title_createaccount), true); // llamamos un recurso desde codigo java // con el parametro true permitimos que el boton se mire
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // estas dos lineas son importantes para que el toolbar tenga soporte para verciones anteriores
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); // en caso de que tenga boton de regreso o boton de subir
                                                                    // y habilitamos que el boton de back sea visble
    }
}
