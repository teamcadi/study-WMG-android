package com.example.wordmemorizationgame.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.wordmemorizationgame.ui.voca.MyvocaFragment;

@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTANCE;
    public abstract WordDao wordDao();

    public static WordDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, WordDatabase.class , "word-db").allowMainThreadQueries().build();
        }
        return  INSTANCE;
    }
}
