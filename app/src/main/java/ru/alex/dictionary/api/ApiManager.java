package ru.alex.dictionary.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.alex.dictionary.models.Results;

public class ApiManager {
    private String appID;
    private String appKey;
    private final IDictionariesApi service;

    public ApiManager(String appID, String appKey) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://od-api.oxforddictionaries.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.appID = appID;
        this.appKey = appKey;

        service = retrofit.create(IDictionariesApi.class);

    }

    public void getDictionaryEntries(String word, Callback<Results> callback) {
        Call<Results> dictionaryEntries = service.getDictionaryEntries(appID, appKey, word);
        dictionaryEntries.enqueue(callback);
    }
}
