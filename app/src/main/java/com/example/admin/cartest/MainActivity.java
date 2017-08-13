package com.example.admin.cartest;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DisplayFragment.OnFragmentInteractionListener, InfoFragment.OnFragmentInteractionListener{

    ArrayList<Car> cars = new ArrayList<>();
    DisplayFragment displayFragment;
    InfoFragment infoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragment = new DisplayFragment();
        infoFragment = new InfoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.infoFragment, infoFragment, "infoFragment").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.displayFragment, displayFragment, "displayFragment").commit();
    }


    @Override
    public void onFragmentInteraction(Car car, String info) {
        if(info == "add"){
            displayFragment.add(car);
            Toast.makeText(this, car.getModel(), Toast.LENGTH_SHORT).show();
        }
        if(info == "show"){
            infoFragment.display(car);
            Toast.makeText(this, car.getModel(), Toast.LENGTH_SHORT).show();

        }
    }
}
