package com.example.wordmemorizationgame.ui.voca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wordmemorizationgame.R;

import java.util.ArrayList;

public class MyvocaAdapter extends RecyclerView.Adapter<MyvocaAdapter.ViewHolder> {
    private ArrayList<MyvocaItem> mData = null;

    MyvocaAdapter(ArrayList<MyvocaItem> list) {
        mData = list;
    }

    @Override
    public MyvocaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.myvoca_item, parent, false);
        MyvocaAdapter.ViewHolder vh = new MyvocaAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyvocaAdapter.ViewHolder holder, int position) {
        MyvocaItem item = mData.get(position);

        holder.word_english.setText(item.getWord_english());
        holder.word_korean.setText(item.getWord_korean());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView word_english;
        TextView word_korean;

        ViewHolder(View itemView) {
            super(itemView) ;

            word_english = itemView.findViewById(R.id.word_english);
            word_korean = itemView.findViewById(R.id.word_korean);
        }
    }
}
