package ru.alex.dictionary.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView tvWord;
        private TextView tvDialect;
        private TextView tvDefinition;
        private TextView tvExample;
        private TextView tvOtherForms;
        private LinearLayout llExample;
        private LinearLayout llDialect;
        private LinearLayout llDefinition;
        private LinearLayout llOtherForms;
        private ImageButton ibPlay;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tv_word);
            tvDialect = itemView.findViewById(R.id.tv_dialect);
            llDialect = itemView.findViewById(R.id.ll_dialect);
            tvDefinition = itemView.findViewById(R.id.tv_definition);
            llDefinition = itemView.findViewById(R.id.ll_definition);
            tvExample = itemView.findViewById(R.id.tv_example);
            llExample = itemView.findViewById(R.id.ll_example);
            tvOtherForms = itemView.findViewById(R.id.tv_other_forms);
            llOtherForms = itemView.findViewById(R.id.ll_other_forms);
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
            isVisible(llDialect, tvDialect, word.getDialect());
            isVisible(llDefinition, tvDefinition, word.getDefinitions());
            isVisible(llExample, tvExample, word.getExample());
            isVisible(llOtherForms, tvOtherForms, word.getOtherForms());
            tvOtherForms.setText(word.getOtherForms());
            if (word.getLink() == null) {
                ibPlay.setEnabled(false);
            }
        }
    }

    private void isVisible(LinearLayout linearLayout, TextView textView, String s) {
        if (s == null) {
            linearLayout.setVisibility(View.GONE);
        } else {
            textView.setText(s);
        }
    }

    public interface OnWordClickListener {
        void onWordClick(DataWord word);
    }

    public interface OnPlayClickListener {
        void onPlayClick(DataWord word);
    }

}