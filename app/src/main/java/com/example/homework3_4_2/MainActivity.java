package com.example.homework3_4_2;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mLanguageSpinner;
    private Spinner mThemeSpinner;
    private Button mOkBtn;
    Locale locale = new Locale("ru");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mLanguageSpinner = findViewById(R.id.languageSpinner);
        mThemeSpinner = findViewById(R.id.themeSpinner);

        mOkBtn = findViewById(R.id.okBtn);
        final Activity thisActivity = this;
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mLanguageSpinner.getSelectedItemPosition() == 0){
                    locale = new Locale("ru");
                }
                if (mLanguageSpinner.getSelectedItemPosition() == 1){
                    locale = new Locale("en-rGB");
                }


                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                Utils.changeToTheme(thisActivity, mThemeSpinner.getSelectedItemPosition());

                recreate();

            }
        });
        initLanguageSpinner();
        initThemeSpinner();


    }

    private void initLanguageSpinner() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguageSpinner.setAdapter(adapterLanguage);

        mLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] language = getResources().getStringArray(R.array.language);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initThemeSpinner() {
        ArrayAdapter<CharSequence> adapterTheme = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_item);
        adapterTheme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mThemeSpinner.setAdapter(adapterTheme);

        mThemeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] color = getResources().getStringArray(R.array.themes);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
