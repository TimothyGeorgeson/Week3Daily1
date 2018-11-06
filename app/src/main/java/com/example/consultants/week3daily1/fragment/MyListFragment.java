package com.example.consultants.week3daily1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.example.consultants.week3daily1.controller.MainController;
import com.example.consultants.week3daily1.model.Person;

import java.util.ArrayList;

public class MyListFragment extends ListFragment {
    private ArrayAdapter<Person> adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Person> personList = MainController.getInstance().getPersonList();
        adapter = new ArrayAdapter<Person>(getActivity(), android.R.layout.simple_list_item_1, personList);
        setListAdapter(adapter);
    }

    public void refreshList()
    {
        adapter.notifyDataSetChanged();
    }
}
