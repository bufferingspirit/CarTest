package com.example.admin.cartest;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DisplayFragment.OnFragmentInteractionListener, InfoFragment.OnFragmentInteractionListener{

    ArrayList<Car> cars = new ArrayList<>();
    DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragment = new DisplayFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.displayFragment, displayFragment, "displayFragment").commit();
    }


    @Override
    public void onFragmentInteraction(Car car, String info) {
        if(info == "add"){
            Toast.makeText(this, car.getModel(), Toast.LENGTH_SHORT).show();
        }
    }
}
