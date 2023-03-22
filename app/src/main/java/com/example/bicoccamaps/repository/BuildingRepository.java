package com.example.bicoccamaps.repository;

//import static it.unimib.worldnews.util.Constants.FRESH_TIMEOUT;
//import static it.unimib.worldnews.util.Constants.TOP_HEADLINES_PAGE_SIZE_VALUE;

import android.app.Application;

import com.example.bicoccamaps.database.BuildingDao;
import com.example.bicoccamaps.database.BuildingRoomDatabase;


/**
 * Repository to get the news using the API
 * provided by NewsApi.org (https://newsapi.org).
 */
//public class BuildingRepository implements IBuildingRepository {

    /*private static final String TAG = BuildingRepository.class.getSimpleName();

    private final Application application;
    private final BuildingDao buildingDao;
    private final NewsResponseCallback newsResponseCallback;

    public BuildingRepository(Application application, NewsResponseCallback newsResponseCallback) {
        this.application = application;
        this.newsApiService = ServiceLocator.getInstance().getNewsApiService();
        BuildingRoomDatabase buildingRoomDatabase = ServiceLocator.getInstance().getNewsDao(application);
        this.buildingDao = buildingRoomDatabase.buildingDao();
        this.newsResponseCallback = newsResponseCallback;
    }


    private void readDataFromDatabase(long lastUpdate) {
        BuildingRoomDatabase.databaseWriteExecutor.execute(() -> {
            newsResponseCallback.onSuccess(buildingDao.getAll(), lastUpdate);
        });
    }*/
//}
