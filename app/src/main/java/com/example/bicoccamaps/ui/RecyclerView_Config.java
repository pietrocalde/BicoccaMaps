package com.example.bicoccamaps.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bicoccamaps.R;
import com.example.bicoccamaps.model.Building;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;

    public void setConfig(RecyclerView recyclerView, Context context, List<Building> buildings, List<String> keys){
        mContext = context;
        BuildingsAdapter mBuildingsAdapter = new BuildingsAdapter(buildings, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mBuildingsAdapter);
    }

    class BuildingItemView extends RecyclerView.ViewHolder{

        private TextView mName;
        private TextView mAddress;
        private String key;

        public BuildingItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.buildings_list_item, parent, false));

            mName = (TextView) itemView.findViewById(R.id.buildingName);
            mAddress = (TextView) itemView.findViewById(R.id.buildingAddress);
        }

        public void bind(Building building, String key){
            mName.setText(building.getName());
            mAddress.setText(building.getAddress());
            this.key = key;
        }
    }
    class BuildingsAdapter extends RecyclerView.Adapter<BuildingItemView>{
        private final List<Building> mBuildingsList;
        private final List<String> mKeys;

        public BuildingsAdapter(List<Building> mBuildingsList, List<String> mKeys) {
            this.mBuildingsList = mBuildingsList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public BuildingItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BuildingItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BuildingItemView holder, int position) {
            holder.bind(mBuildingsList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mBuildingsList.size();
        }
    }
}

