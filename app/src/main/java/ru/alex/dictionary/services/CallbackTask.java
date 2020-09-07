package ru.alex.dictionary.services;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ru.alex.dictionary.contractors.MainContractor;
import ru.alex.dictionary.models.DataWord;
import ru.alex.dictionary.presenters.MainPresenter;

public class CallbackTask extends AsyncTask<String, Integer, String> {

    private MainContractor.Presenter mPresenter;
    private String app_id;
    private String app_key;

    public CallbackTask(MainPresenter mainPresenter, String apiID, String apiKey) {
        mPresenter = mainPresenter;
        app_id = apiID;
        app_key = apiKey;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();

        } catch (FileNotFoundException e) {
            return "Not file";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (!result.equals("Error") && !result.equals("Not file")) {
            List<DataWord> dataWords = new ArrayList<>();
            try {
                JSONObject object = new JSONObject(result);
                JSONArray results = object.getJSONArray("results");
                for (int i = 0; i < results.length(); i++) {
                    JSONObject resultsObject = results.getJSONObject(i);
                    DataWord dataWord = new DataWord();
                    dataWord.setWord(resultsObject.getString("word"));
                    JSONArray lexicalEntries = resultsObject.getJSONArray("lexicalEntries");
                    JSONObject lexicalEntriesObject = lexicalEntries.getJSONObject(0);
                    dataWord.setDefinitions(lexicalEntriesObject.getString("text"));
                    JSONArray entries = lexicalEntriesObject.getJSONArray("entries");
                    JSONObject entriesObject = entries.getJSONObject(0);
                    JSONArray pronunciations = entriesObject.getJSONArray("pronunciations");
                    JSONObject pronunciationsObject = pronunciations.getJSONObject(0);
                    dataWord.setLink(pronunciationsObject.getString("audioFile"));
                    dataWord.setDialect(pronunciationsObject.getString("dialects").replaceAll("[\"\\[\\]]", ""));
                    JSONArray senses = entriesObject.getJSONArray("senses");
                    JSONObject sensesObject = senses.getJSONObject(0);
                    try {
                        JSONArray examples = sensesObject.getJSONArray("examples");
                        JSONObject examplesObject = examples.getJSONObject(0);
                        dataWord.setExample(examplesObject.getString("text"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    dataWord.setDefinitions(sensesObject.getString("definitions").replaceAll("[\"\\[\\]]", ""));
                    JSONArray variantForms = entriesObject.getJSONArray("variantForms");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j < variantForms.length(); j++) {
                        JSONObject variantFormsObject = variantForms.getJSONObject(j);
                        stringBuilder.append(variantFormsObject.getString("text"));
                        if (j < variantForms.length() - 1) {
                            stringBuilder.append(", ");
                        }
                    }
                    dataWord.setOtherForms(stringBuilder.toString());
                    dataWords.add(dataWord);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mPresenter.loadWords(dataWords);
        } else {
            mPresenter.returnError(result);
        }
    }
}