package ru.alex.dictionary.presenters;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.alex.dictionary.R;
import ru.alex.dictionary.adapters.RecyclerViewMainAdapter;
import ru.alex.dictionary.api.ApiManager;
import ru.alex.dictionary.contractors.MainContractor;
import ru.alex.dictionary.models.DataWord;
import ru.alex.dictionary.models.Entry;
import ru.alex.dictionary.models.Result;
import ru.alex.dictionary.models.Results;
import ru.alex.dictionary.models.VariantForm;

public class MainPresenter implements MainContractor.Presenter, Callback<Results> {

    private MainContractor.View mView;
    private RecyclerViewMainAdapter adapter;
    private List<DataWord> dataWords;

    public MainPresenter(MainContractor.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadWords(List<DataWord> dataWords) {
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
        ApiManager apiManager = new ApiManager(apiID, apiKey);
        apiManager.getDictionaryEntries(word, this);
    }

    @Override
    public void onResponse(@NonNull Call<Results> call, Response<Results> response) {
        if (response.isSuccessful()) {
            dataWords = new ArrayList<>();
            DataWord dataWord = new DataWord();
            String regex = "[\"\\[\\]]";
            Results body = response.body();
            for (Result result : Objects.requireNonNull(body).getResults()) {
                dataWord.setWord(result.getWord());
                Entry entry = result.getLexicalEntries().get(0).getEntries().get(0);
                try {
                    dataWord.setLink(entry.getPronunciations().get(0).getAudioFile());
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    dataWord.setDialect(entry.getPronunciations().get(0).getDialects().get(0)
                            .replaceAll(regex, ""));
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    dataWord.setExample(entry.getSenses().get(0).getExamples().get(0).getText());
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    dataWord.setDefinitions(entry.getSenses().get(0).getDefinitions().get(0)
                            .replaceAll(regex, ""));
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    for (int i = 0; i < entry.getVariantForms().size(); i ++) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(entry.getVariantForms().get(i).getText());
                        if (i < entry.getVariantForms().size() - 1) {
                            stringBuilder.append(", ");
                        }
                    }
                    dataWord.setOtherForms(entry.getVariantForms().get(0).getText());
                } catch (IndexOutOfBoundsException ignored) {
                }
                dataWords.add(dataWord);
            }
            loadWords(dataWords);
        } else if (response.code() == 404) {
            mView.showSnackbar(((Context) mView).getString(R.string.error_not_file));
        } else if (response.code() == 403) {
            mView.showSnackbar(((Context) mView).getString(R.string.error_api));
        } else {
            mView.showSnackbar(((Context) mView).getString(R.string.other_error));
        }
    }

    @Override
    public void onFailure(@NonNull Call<Results> call, @NonNull Throwable t) {
        mView.showSnackbar(((Context) mView).getString(R.string.error_connection));
    }
}
