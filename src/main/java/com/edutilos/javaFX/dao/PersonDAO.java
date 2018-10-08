package com.edutilos.javaFX.dao;

import com.edutilos.javaFX.model.Person;

import java.util.List;

public class PersonDAO implements DAO<Person,Integer> {
    @Override
    public void create(Person person) {

    }

    @Override
    public void update(Integer integer, Person person) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Person find(Integer integer) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }
}
