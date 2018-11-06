package com.example.consultants.week3daily1.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.consultants.week3daily1.MyListFragment;
import com.example.consultants.week3daily1.R;
import com.example.consultants.week3daily1.controller.MainController;
import com.example.consultants.week3daily1.model.Person;

public class ListFragmentActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;
    private EditText etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etGender = findViewById(R.id.etGender);
    }

    public void addPerson(View view) {
        MainController.getInstance().addPerson(etName.getText().toString(),
                etAge.getText().toString(), etGender.getText().toString());
        MyListFragment myListFragment = (MyListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentHolder2);
        myListFragment.refreshList();
    }
}
