package com.example.etxu_pc_windows.ggec.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.etxu_pc_windows.ggec.R;
import com.example.etxu_pc_windows.ggec.adapters.SectionsAdapter;
import com.example.etxu_pc_windows.ggec.classes.Utilities;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContainerTabs.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContainerTabs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContainerTabs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    View view;
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    public ContainerTabs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContainerTabs.
     */
    // TODO: Rename and change types and number of parameters
    public static ContainerTabs newInstance(String param1, String param2) {
        ContainerTabs fragment = new ContainerTabs();
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
    public void onDestroyView() {
        super.onDestroyView();
        if(Utilities.rotation == 0) {
            appBar.removeView(tabs);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_container_tabs, container, false);

        View parent = (View) container.getParent();

        if (Utilities.rotation == 0) {
            if (appBar == null) {
                appBar = (AppBarLayout) parent.findViewById(R.id.appBar);
                tabs = new TabLayout(getActivity());
                tabs.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"));
                appBar.addView(tabs);

                viewPager = view.findViewById(R.id.viewPagerTabs);
                createViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

                tabs.setupWithViewPager(viewPager);
            }
            tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        } else {
            Utilities.rotation = 1;
        }

        return view;
    }

    private void createViewPager(ViewPager viewPager) {
        SectionsAdapter adapter = new SectionsAdapter(getFragmentManager());
        adapter.addFragment(new LandingDashboard(), "Resumen");
        adapter.addFragment(new AddDriver(), "Dos");
        adapter.addFragment(new AddTruck(), "Tres");

        viewPager.setAdapter(adapter);
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
