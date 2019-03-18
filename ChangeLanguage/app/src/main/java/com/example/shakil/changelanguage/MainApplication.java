package com.example.shakil.changelanguage;

import android.app.Application;
import android.content.Context;

import com.example.shakil.changelanguage.Helper.LocaleHelper;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
