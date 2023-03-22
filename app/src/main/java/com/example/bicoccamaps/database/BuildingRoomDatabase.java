package com.example.bicoccamaps.database;


import static com.example.bicoccamaps.util.Constants.BUILDING_DATABASE_NAME;
import static com.example.bicoccamaps.util.Constants.DATABASE_VERSION;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.bicoccamaps.model.Building;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main access point for the underlying connection to the local database.
 * https://developer.android.com/reference/kotlin/androidx/room/Database
 */
@Database(entities = {Building.class}, version = DATABASE_VERSION)

public abstract class BuildingRoomDatabase extends RoomDatabase {

    public abstract BuildingDao buildingDao();

    private static volatile BuildingRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BuildingRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BuildingRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BuildingRoomDatabase.class, "BicoccaMaps.db")
                            .createFromAsset("BicoccaMaps.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}



