package com.example.admin.cartest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayFragment extends Fragment{

    private ArrayList<Car> cars;
    CarAdapter carAdapter;
    private RecyclerView rView;
    LinearLayoutManager layoutManager;
    DefaultItemAnimator itemAnimator;

    private OnFragmentInteractionListener mListener;

    public DisplayFragment() {

    }
    // TODO: Rename and change types and number of parameters
    public static DisplayFragment newInstance(ArrayList<Car> cars) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putSerializable("cars", cars);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cars = (ArrayList<Car>) getArguments().getSerializable("cars");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rView = (RecyclerView) view.findViewById(R.id.rView);
        layoutManager = new LinearLayoutManager(getContext());
        itemAnimator = new DefaultItemAnimator();
        rView.setLayoutManager(layoutManager);
        rView.setItemAnimator(itemAnimator);
        carAdapter = new CarAdapter(cars);
        rView.setAdapter(carAdapter);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Car car) {
        if (mListener != null) {
            mListener.onFragmentInteraction(car, "");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Car car, String info);
    }
}
