package com.example.consultants.week3daily1.controller;

import com.example.consultants.week3daily1.model.Person;

import java.util.ArrayList;

public class MainController {

    public static MainController instance;
    private ArrayList<Person> personList;

    private MainController()
    {
        this.personList = new ArrayList<Person>();
    }

    public static MainController getInstance()
    {
        if(instance == null)
        {
            instance = new MainController();
        }
        return instance;
    }

    public void addPerson(String name, String age, String gender)
    {
        Person person = new Person(name, age, gender);
        personList.add(person);
    }

    public ArrayList<Person> getPersonList()
    {
        return this.personList;
    }
}
