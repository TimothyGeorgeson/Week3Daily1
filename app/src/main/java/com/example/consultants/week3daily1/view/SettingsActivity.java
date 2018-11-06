package com.example.consultants.week3daily1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.consultants.week3daily1.R;
import com.example.consultants.week3daily1.fragment.MyPrefsFragment;

public class SettingsActivity extends AppCompatActivity {
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        MyPrefsFragment myPrefsFragment = new MyPrefsFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder3, myPrefsFragment)
                .commit();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings)
        {
            startActivity(new Intent(this, SettingsActivity.class));
        }

        return true;
    }
}
