package ru.alex.dictionary.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import ru.alex.dictionary.models.Results;

public interface IDictionariesApi {
    @GET("entries/en-gb/{word}?&strictMatch=false")
    Call<Results> getDictionaryEntries(@Header("app_id") String id,
                                       @Header("app_key") String key,
                                       @Path("word") String word);
}
