package com.example.consultants.week3daily1.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.consultants.week3daily1.R;
import com.example.consultants.week3daily1.fragment.MyPrefsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        MyPrefsFragment myPrefsFragment = new MyPrefsFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder3, myPrefsFragment)
                .commit();
    }
}
