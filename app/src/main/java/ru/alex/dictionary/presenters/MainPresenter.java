package ru.alex.dictionary.presenters;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;

import java.io.IOException;
import java.util.List;

import ru.alex.dictionary.R;
import ru.alex.dictionary.adapters.RecyclerViewMainAdapter;
import ru.alex.dictionary.contractors.MainContractor;
import ru.alex.dictionary.models.DataWord;

public class MainPresenter implements MainContractor.Presenter {

    private MainContractor.View mView;
    private MainContractor.Repository mRepository;
    private RecyclerViewMainAdapter adapter;
    private List<DataWord> dataWords;

    public MainPresenter(MainContractor.View mView) {
        this.mView = mView;
        mRepository = new DataWord();
    }

    @Override
    public void loadWords(final List<DataWord> dataWords) {
        this.dataWords = dataWords;
        RecyclerViewMainAdapter.OnWordClickListener wordClickListener = new RecyclerViewMainAdapter.OnWordClickListener() {
            @Override
            public void onWordClick(DataWord word) {
                mView.showToast(word.getWord());
            }
        };
        RecyclerViewMainAdapter.OnPlayClickListener playClickListener = new RecyclerViewMainAdapter.OnPlayClickListener() {
            @Override
            public void onPlayClick(DataWord word) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioAttributes(
                        new AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                );
                try {
                    mediaPlayer.setDataSource(word.getLink());
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        };
        adapter = new RecyclerViewMainAdapter(this.dataWords, wordClickListener, playClickListener);
        mView.updateRV(adapter);
    }

    @Override
    public void loadWords(String apiID, String apiKey, String word) {
        mRepository.getWords(this, apiID, apiKey, word);
    }

    @Override
    public void returnError(String errorMessage) {
        if (errorMessage.equals("Error")) {
            mView.showSnackbar(((Context) mView).getString(R.string.error_message));
        } else if (errorMessage.equals("Not file")) {
            mView.showSnackbar(((Context) mView).getString(R.string.error_not_file));
        }
    }
}
