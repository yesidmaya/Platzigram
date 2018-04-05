package com.platzi.platzigram.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.platzi.platzigram.R;
import com.platzi.platzigram.view.fragment.HomeFragment;
import com.platzi.platzigram.view.fragment.ProfileFragment;
import com.platzi.platzigram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar); //hacemos referencia a bottombar
        bottomBar.setDefaultTab(R.id.home); //cuando se abra la pantalla este en la tab home
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerid, homeFragment) // el primer parametro de replace es en donce quiero colocar el fragment y el segundo es que vista quiro colocar
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) // .setTransition es para que no se mire muy seguido
                            .addToBackStack(null).commit();// si estamos utilizando transactions es bueno colocar .addToBackStack
                        break;
                    case R.id.profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerid, profileFragment) // el primer parametro de replace es en donce quiero colocar el fragment y el segundo es que vista quiro colocar
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) // .setTransition es para que no se mire muy seguido
                                .addToBackStack(null).commit();// si estamos utilizando transactions es bueno colocar .addToBackStack
                        break;
                    case R.id.search:
                        SearchFragment searchFragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerid, searchFragment) // el primer parametro de replace es en donce quiero colocar el fragment y el segundo es que vista quiro colocar
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) // .setTransition es para que no se mire muy seguido
                                .addToBackStack(null).commit();// si estamos utilizando transactions es bueno colocar .addToBackStack
                        break;
                }

            }
        }); //va a estar atento cuando se le de clic a una de las tab para saber que fragment va a mostrar

    }
}
