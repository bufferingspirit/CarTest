package com.example.admin.cartest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

/**
 * Created by Admin on 8/11/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    List<Car> cars;
    private static String TAG = "Cars: ";
    Context context;
    DisplayFragment fragment;

    //Context context;

    public CarAdapter(List<Car> carList, DisplayFragment frag){
        this.cars = carList;
        fragment = frag;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvModel;

        public ViewHolder(View itemView) {
            super(itemView);

            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_entry, parent, false);
        return new ViewHolder(view);
    }

    // private int lastPosition = -1;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        /*Hif(position>lastPosition){
            Animation animation = AnimationUtils.loadAnimation()
        }*/
        Log.d(TAG, "onBindViewHolder: " + position);
        final Car car = cars.get(position);
        holder.tvModel.setText(car.getModel());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragment.display(car);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(cars == null){
            return 0;
        }
        else {
            return cars.size();
        }
    }
}
