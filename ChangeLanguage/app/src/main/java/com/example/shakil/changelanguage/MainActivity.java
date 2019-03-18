package com.example.shakil.changelanguage;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.shakil.changelanguage.Helper.LocaleHelper;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    TextView textView, textViewLanguage;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view_text);
        textViewLanguage = findViewById(R.id.text_view_language);

        //Init Paper first
        Paper.init(this);

        //Default Language is English
        String language = Paper.book().read("language");
        if (language == null){
            Paper.book().write("language", "en");
        }
        updateView((String) Paper.book().read("language"));

    }

    private void updateView(String language) {
        Context context = LocaleHelper.setLocale(this, language);
        Resources resources = context.getResources();

        textView.setText(resources.getString(R.string.hello));
        textViewLanguage.setText(resources.getString(R.string.language));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.language_en){
            Paper.book().write("language", "en");
            updateView((String) Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_bn){
            Paper.book().write("language", "bn");
            updateView((String) Paper.book().read("language"));
        }

        else if (item.getItemId() == R.id.language_fr){
            Paper.book().write("language", "fr");
            updateView((String) Paper.book().read("language"));
        }
        return true;
    }
}
