package com.example.wordmemorizationgame.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Query("SELECT * FROM word")
    List<Word> getAll();

    @Query("SELECT word_english FROM word")
    List<String> getWord_englishAll();

    @Query("SELECT word_korean FROM word")
    List<String> getWord_koreanAll();

    @Insert
    void insertAll(Word... words);

    @Delete
    void delete(Word word);
}
