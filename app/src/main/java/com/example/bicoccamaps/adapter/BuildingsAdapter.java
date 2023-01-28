package com.example.bicoccamaps.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bicoccamaps.R;
import com.example.bicoccamaps.model.Building;

import java.util.List;

public class BuildingsAdapter extends RecyclerView.Adapter<BuildingsAdapter.BuildingViewHolder>{
    public interface OnItemClickListener{
        void onBuildingClick(Building building);
    }
    private List<Building> buildingList;
    private OnItemClickListener onItemClickListener;

    public BuildingsAdapter(List<Building> buildingList, OnItemClickListener onItemClickListener){
        this.buildingList = buildingList;
        this.onItemClickListener =onItemClickListener;
    }

    @NonNull
    @Override
    public BuildingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_list,parent,false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingViewHolder holder, int position) {
        holder.bind(buildingList.get(position));
    }

    @Override
    public int getItemCount() {
        if (buildingList != null){
            return buildingList.size();
        }
        return 0;
    }

    public class BuildingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView textViewName;
        private final TextView textViewAddress;
        public BuildingViewHolder(@NonNull View itemView) {
            super(itemView);
        textViewName = itemView.findViewById(R.id.textview_name);
        textViewAddress = itemView.findViewById(R.id.textview_address);
        }
        public void bind(Building building){
            textViewName.setText(building.getName());
            textViewAddress.setText(building.getAddress());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onBuildingClick(buildingList.get(getAdapterPosition()));
        }
    }
}

