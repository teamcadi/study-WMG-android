package com.example.wordmemorizationgame.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "word_english")
    public String word_english;

    @ColumnInfo(name = "word_korean")
    public String word_korean;
}
