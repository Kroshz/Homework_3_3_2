package com.kroshz.homework_3_3_2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mLanguageSpinner;
    private Button mOkButton;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mLanguageSpinner =findViewById(R.id.languageSpinner);
        mOkButton = findViewById(R.id.okButton);
        mTv = findViewById(R.id.tv);
        initLanguageSpinner();
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lang = mLanguageSpinner.getSelectedItem().toString();
                switch (lang) {
                    case "Русский": {
                        switchLocale("ru");
                        break;
                    }
                    case "English": {
                        switchLocale("en");
                        break;
                    }
                }
            }
        });
    }
    private void initLanguageSpinner() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguageSpinner.setAdapter(adapterCountries);
    }
    private void switchLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

}
