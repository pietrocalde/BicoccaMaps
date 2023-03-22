package com.example.bicoccamaps.repository;

import androidx.lifecycle.MutableLiveData;
import com.example.bicoccamaps.model.Building;
import javax.xml.transform.Result;
import java.util.List;

public interface IBuildingRepository {

    enum JsonParserType {
        JSON_READER,
        JSON_OBJECT_ARRAY,
        GSON,
        JSON_ERROR
    }

    void fetchBuilding(String country, int page, long lastUpdate);

    void updateBuilding(Building building);

    void getFavoriteBuilding();

    void deleteFavoriteBuilding();
}
