package ru.alex.dictionary.contractors;

import java.util.List;

import ru.alex.dictionary.adapters.RecyclerViewMainAdapter;
import ru.alex.dictionary.models.DataWord;
import ru.alex.dictionary.presenters.MainPresenter;

public interface MainContractor {

    interface View {

        void updateRV(RecyclerViewMainAdapter adapter);

        void showToast(String word);

        void showSnackbar(String message);
    }

    interface Presenter {

        void loadWords(List<DataWord> dataWords);

        void loadWords(String apiID, String apiKey, String word);

    }
}
