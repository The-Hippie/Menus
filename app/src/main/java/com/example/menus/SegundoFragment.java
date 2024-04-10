package com.example.menus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SegundoFragment extends Fragment {

    //  recursos de imagen
    final Integer[] images = {R.drawable.images, R.drawable.mazdarx, R.drawable.cuda, R.drawable.chevrolet};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        Spinner spinner = view.findViewById(R.id.spinner);

        // Crear un ArrayAdapter usando un layout personalizado y el array de imágenes
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                getActivity(), R.layout.spinner_layout, images) {

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                return getImageForPosition(position);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return getImageForPosition(position);
            }

            private View getImageForPosition(int position) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(images[position]);
                return imageView;
            }
        };

        // Aplicar el adaptador al spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Integer selectedImage = (Integer) parent.getSelectedItem();
                // Ahora puedes usar selectedImage
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se seleccionó nada
            }
        });

        return view;
    }
}