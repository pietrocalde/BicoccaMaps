package com.example.bicoccamaps.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bicoccamaps.model.Building;

import java.util.List;

/**
 * Data Access Object (DAO) that provides methods that can be used to query,
 * update, insert, and delete data in the database.
 * https://developer.android.com/training/data-storage/room/accessing-data
 */

@Dao
public interface BuildingDao {
    @Query("SELECT * FROM Building ORDER BY id ASC")
    List<Building> getAll();

    @Query("SELECT * FROM Building WHERE id = :id")
    Building getBuilding(long id);

    //@Query("SELECT * FROM Building WHERE is_favorite = 1 ORDER BY published_at DESC")
    //List<Building> getFavoriteBuilding();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertBuildingList(List<Building> BuildingList);

    @Insert
    void insertAll(Building... Building);

    @Update
    int updateSingleFavoriteBuilding(Building Building);

    @Update
    int updateListFavoriteBuilding(List<Building> Building);

    @Delete
    void delete(Building Building);

    @Delete
    void deleteAllWithoutQuery(Building... Building);

    @Query("DELETE FROM Building")
    int deleteAll();

    //@Query("DELETE FROM Building WHERE is_favorite = 0")
    //void deleteNotFavoriteBuilding();

}
