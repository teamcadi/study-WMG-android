package com.example.wordmemorizationgame.ui.voca;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wordmemorizationgame.R;
import com.example.wordmemorizationgame.database.Word;
import com.example.wordmemorizationgame.database.WordDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyvocaFragment extends Fragment {

    public MyvocaFragment() {
        // Required empty public constructor
    }

    RecyclerView mRecyclerView = null;
    MyvocaAdapter mAdapter = null;
    ArrayList<MyvocaItem> mList = new ArrayList<MyvocaItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_myvoca, container, false);
        mRecyclerView = (RecyclerView)layout.findViewById(R.id.recycler);
        WordDatabase wordDatabase = WordDatabase.getAppDatabase(getContext());

        mAdapter = new MyvocaAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> word_english_list = wordDatabase.wordDao().getWord_englishAll();
        List<String> word_korean_list = wordDatabase.wordDao().getWord_koreanAll();

        String[] word_english_array = word_english_list.toArray(new String[word_english_list.size()]);
        String[] word_korean_array = word_korean_list.toArray(new String[word_korean_list.size()]);

        for(int i=0; i<word_english_array.length; i++){
            addItem(word_english_array[i], word_korean_array[i]);
        }

        //테스트
        /*
        Word new_word = new Word();
        new_word.word_english = "peach";
        new_word.word_korean = "복숭아";
        wordDatabase.wordDao().insertAll(new_word);

        addItem("apple", "사과");
        addItem("orange", "오렌지");
        addItem("banana", "바나나");
         */

        mAdapter.notifyDataSetChanged();

        return layout;
    }

    public void addItem(String word_english, String word_korean) { //String word_english, String word_korean
        MyvocaItem item = new MyvocaItem();

        item.setWord_english(word_english);
        item.setWord_korean(word_korean);

        mList.add(item);
    }
}