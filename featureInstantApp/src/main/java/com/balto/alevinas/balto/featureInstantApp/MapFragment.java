package com.balto.alevinas.balto.featureInstantApp;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Random;

import static java.lang.Thread.sleep;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private boolean resumeAnimation = true;

    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        final ImageView lucky = (ImageView) getActivity().findViewById(R.id.lucky);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        AnimationSet as = new AnimationSet(false);

        int left = lucky.getLeft();
        int top = lucky.getTop();


        TranslateAnimation anim = new TranslateAnimation(left, 10, top, 500); //Use current view position instead of `currentX` and `currentY`
        anim.setDuration(3000);
        anim.setFillAfter(true);

        as.addAnimation(anim);

        //lucky.startAnimation(anim);

        TranslateAnimation anim2 = new TranslateAnimation(left + 10, 200, top + 100, 0); //Use current view position instead of `currentX` and `currentY`
        anim2.setDuration(3000);
        anim2.setStartOffset(3000);
        anim2.setFillAfter(true);

        as.addAnimation(anim2);

        //lucky.startAnimation(anim2);

        TranslateAnimation anim3 = new TranslateAnimation(left + 10 + 200, 100, top + 100, 100); //Use current view position instead of `currentX` and `currentY`
        anim3.setDuration(3000);
        anim3.setStartOffset(6000);
        anim3.setFillAfter(true);
        //anim3.setRepeatCount(Animation.INFINITE);
        //lucky.startAnimation(anim3);
        as.addAnimation(anim3);

        TranslateAnimation anim4 = new TranslateAnimation(left + 10 + 300, 500, top + 200, 500); //Use current view position instead of `currentX` and `currentY`
        anim4.setDuration(3000);
        anim4.setStartOffset(9000);
        anim4.setFillAfter(true);

        as.addAnimation(anim4);
        as.setRepeatMode(Animation.INFINITE);
        lucky.startAnimation(as);

    }

    @Override
    public void onPause() {
        super.onPause();
        resumeAnimation = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        void onFragmentInteraction(Uri uri);
    }
}
