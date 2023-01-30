package com.example.bicoccamaps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Class to represent the API response of NewsAPI.org (https://newsapi.org)
 * associated with the endpoint "Top headlines" - /v2/top-headlines.
 */

public class BuildingApiResponse implements Parcelable {

    private String status;
    private int totalResults;
    private List<Building> buildings;

    public BuildingApiResponse() {}

    public BuildingApiResponse(String status, int totalResults, List<Building> buildings) {
        this.status = status;
        this.totalResults = totalResults;
        this.buildings = buildings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        return "NewsApiResponse{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", buildings=" + buildings +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeInt(this.totalResults);
        dest.writeTypedList(this.buildings);
    }

    public void readFromParcel(Parcel source) {
        this.status = source.readString();
        this.totalResults = source.readInt();
        this.buildings = source.createTypedArrayList(Building.CREATOR);
    }

    protected BuildingApiResponse(Parcel in) {
        this.status = in.readString();
        this.totalResults = in.readInt();
        this.buildings = in.createTypedArrayList(Building.CREATOR);
    }

    public static final Parcelable.Creator<BuildingApiResponse> CREATOR = new Parcelable.Creator<BuildingApiResponse>() {
        @Override
        public BuildingApiResponse createFromParcel(Parcel source) {
            return new BuildingApiResponse(source);
        }

        @Override
        public BuildingApiResponse[] newArray(int size) {
            return new BuildingApiResponse[size];
        }
    };
}


