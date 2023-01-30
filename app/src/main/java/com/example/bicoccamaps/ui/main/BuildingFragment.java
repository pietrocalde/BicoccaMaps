package com.example.bicoccamaps.ui.main;

import static com.example.bicoccamaps.R.id.recyclerView_buildings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bicoccamaps.R;
import com.example.bicoccamaps.model.Building;
import com.example.bicoccamaps.adapter.BuildingsAdapter;
import com.example.bicoccamaps.model.BuildingApiResponse;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuildingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuildingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BuildingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuildingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuildingFragment newInstance(String param1, String param2) {
        BuildingFragment fragment = new BuildingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_building, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menu.clear();
            }

            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });

        RecyclerView recyclerViewBuildings =view.findViewById(recyclerView_buildings);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        recyclerViewBuildings.setLayoutManager(linearLayoutManager);

        List<Building> buildingsArray= new ArrayList<>();
        for (int i =0; i< 50; i++) {
            buildingsArray.add(new Building("nome"+i, "indirizzo"+i));
        }


        BuildingsAdapter adapter = new BuildingsAdapter(parseJSON(), new BuildingsAdapter.OnItemClickListener() {
            @Override
            public void onBuildingClick(Building building) {
                /* ID per creare pagine specifiche */
                Snackbar.make(view, building.getName(), Snackbar.LENGTH_SHORT).show();
            }
        });
        recyclerViewBuildings.setAdapter(adapter);
    }

    private List<Building> parseJSON() {
        InputStream inputStream = null;
        try {
            inputStream = requireActivity().getAssets().open("buildings.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        BuildingApiResponse buildingsApiResponse = new Gson().fromJson(bufferedReader, BuildingApiResponse.class);
        return buildingsApiResponse.getBuildings();
    }
}











