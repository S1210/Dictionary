package ru.alex.dictionary.presenters;

import android.media.AudioAttributes;
import android.media.MediaPlayer;

import java.io.IOException;
import java.util.List;

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
    public void loadTravels(final List<DataWord> dataWords) {
        this.dataWords = dataWords;
        RecyclerViewMainAdapter.OnWordClickListener wordClickListener = new RecyclerViewMainAdapter.OnWordClickListener() {
            @Override
            public void onWordClick(DataWord word) {
//                Intent intent = new Intent((Context) mView, TravelActivity.class);
//                intent.putExtra(DBHelper.ID_TRAVEL, travel.getId());
//                intent.putExtra(DBHelper.NAME, travel.getNameTravel());
//                mView.openTravel(intent);
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
}
