package ru.alex.dictionary.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

import ru.alex.dictionary.R;
import ru.alex.dictionary.models.DataWord;

public class RecyclerViewMainAdapter extends RecyclerView.Adapter<RecyclerViewMainAdapter.RecyclerViewHolder> {

    private List<DataWord> list;
    private OnWordClickListener wordClickListener;
    private OnPlayClickListener playClickListener;

    public RecyclerViewMainAdapter(List<DataWord> list, OnWordClickListener wordClickListener,
                                   OnPlayClickListener playClickListener) {
        this.list = list;
        this.wordClickListener = wordClickListener;
        this.playClickListener = playClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_main, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(Collection<DataWord> words) {
        list.addAll(words);
        notifyDataSetChanged();
    }

    public void clearItems() {
        list.clear();
        notifyDataSetChanged();
    }

    public void addItems(int position, List<DataWord> words) {
        list.add(position, words.get(position));
        notifyItemInserted(position);
    }

    public void removeItems(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView tvWord;
        private ImageButton ibPlay;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tv_word);
            ibPlay = itemView.findViewById(R.id.ibPlay);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataWord word = list.get(getLayoutPosition());
                    wordClickListener.onWordClick(word);
                }
            });
            ibPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataWord dataWord = list.get(getLayoutPosition());
                    playClickListener.onPlayClick(dataWord);
                }
            });
        }

        @SuppressLint("SetTextI18n")
        public void bind(DataWord word) {
            tvWord.setText(word.getWord());
        }
    }

    public interface OnWordClickListener {
        void onWordClick(DataWord word);
    }

    public interface OnPlayClickListener {
        void onPlayClick(DataWord word);
    }

}
