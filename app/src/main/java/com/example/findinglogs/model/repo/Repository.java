package com.example.findinglogs.model.repo;


import android.app.Application;

import com.example.findinglogs.model.repo.local.SharedPrefManager;
import com.example.findinglogs.model.repo.remote.WeatherManager;
import com.example.findinglogs.model.repo.remote.api.WeatherCallback;
import com.example.findinglogs.model.util.Logger;

import java.util.HashSet;

public class Repository {
    private static final String TAG = Repository.class.getSimpleName();

    private final WeatherManager weatherManager;
    private final SharedPrefManager sharedPrefManagerManager;

    public Repository(Application application) {
        if (Logger.ISLOGABLE) Logger.d(TAG, "Repository()");
        weatherManager = new WeatherManager();
        sharedPrefManagerManager = SharedPrefManager.getInstance(application);
    }

    public void retrieveForecast(String latLon, WeatherCallback callback) {
        if (Logger.ISLOGABLE) Logger.d(TAG, "retrieveForecast for:" + latLon);
        weatherManager.retrieveForecast(latLon, callback);
    }

    public void saveString(String key, String value) {
        if (Logger.ISLOGABLE) Logger.d(TAG, "saveString()");
        sharedPrefManagerManager.writeString(key, value);
    }

    public String readString(String key) {
        if (Logger.ISLOGABLE) Logger.d(TAG, "readString()");
        return sharedPrefManagerManager.readString(key);
    }

    public HashSet<String> getLocalizations() {
        HashSet<String> localizations = new HashSet<>();
        localizations.add("-8.05428,-34.8813");
        localizations.add("-9.39416,-40.5096");
        localizations.add("-8.284547,-35.969863");
        localizations.add("-3.10719,-60.0261");     // Manaus - AM
        localizations.add("-23.55052,-46.63331");   // São Paulo - SP
        localizations.add("-22.90685,-43.1729");    // Rio de Janeiro - RJ
        localizations.add("-30.03465,-51.21766");   // Porto Alegre - RS
        localizations.add("-19.91668,-43.93449");   // Belo Horizonte - MG
        localizations.add("-12.9714,-38.5014");     // Salvador - BA
        localizations.add("-15.7801,-47.9292");    // Brasília - DF
        localizations.add("-3.71722,-38.5433");    // Fortaleza - CE
        localizations.add("-1.45502,-48.5024");    // Belém - PA
        localizations.add("-8.06315,-34.8711");    // Recife - PE
        localizations.add("-7.1195,-34.845");      // João Pessoa - PB
        localizations.add("-16.6864,-49.2643");    // Goiânia - GO
        localizations.add("-10.9472,-37.0731");    // Aracaju - SE
        localizations.add("-2.53073,-44.3068");    // São Luís - MA
        localizations.add("-22.1207,-51.3926");    // Presidente Prudente - SP
        localizations.add("-21.7611,-43.3496");    // Juiz de Fora - MG

        return localizations;
    }
}