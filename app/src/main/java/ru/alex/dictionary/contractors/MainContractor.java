package ru.alex.dictionary.contractors;

import java.util.List;

import ru.alex.dictionary.adapters.RecyclerViewMainAdapter;
import ru.alex.dictionary.models.DataWord;

public interface MainContractor {

    interface View {

        void updateRV(RecyclerViewMainAdapter adapter);
    }

    interface Presenter {

        void loadTravels(List<DataWord> dataWords);
    }

    interface Repository {

    }
}
