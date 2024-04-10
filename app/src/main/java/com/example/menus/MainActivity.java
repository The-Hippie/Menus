package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    InicioFragment inicioFragment = new InicioFragment();
    SegundoFragment segundoFragment = new SegundoFragment();

    FrameLayout pantalla1;
    BottomNavigationView pantalla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla1 =findViewById(R.id.pantalla1);
        pantalla2 = findViewById(R.id.pantalla2);

        pantalla2.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_inicio){
                    cargando_fragmento((Fragment) inicioFragment);

                    return true;
                }
                if(item.getItemId()==R.id.nav_galeria){
                    cargando_fragmento(segundoFragment);

                    return true;
                }

                return false;


            }
        });
    }
    public void cargando_fragmento(Fragment fr){
        FragmentTransaction Transaccion = getSupportFragmentManager().beginTransaction();
        Transaccion.replace(R.id.pantalla1,fr);
        Transaccion.commit();
    }
}
