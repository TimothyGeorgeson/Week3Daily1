package com.example.consultants.week3daily1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consultants.week3daily1.fragment.MyListFragment;
import com.example.consultants.week3daily1.R;
import com.example.consultants.week3daily1.controller.MainController;

public class ListFragmentActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;
    private EditText etGender;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etGender = findViewById(R.id.etGender);

        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    public void addPerson(View view) {
        MainController.getInstance().addPerson(etName.getText().toString(),
                etAge.getText().toString(), etGender.getText().toString());
        MyListFragment myListFragment = (MyListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentHolder2);
        myListFragment.refreshList();
        Toast.makeText(this, "Person Added!", Toast.LENGTH_SHORT).show();
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
