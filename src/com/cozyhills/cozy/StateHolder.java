package com.cozyhills.cozy;

import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.map.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pere5 on 23/12/15.
 */
public class StateHolder {
    List<List<VisibleEntity>> state = new ArrayList<List<VisibleEntity>>();

    public StateHolder() {
        createPersons(state);
        createNature(state);
    }

    public List<VisibleEntity> getPersons() {
        return state.get(0);
    }

    public List<List<VisibleEntity>> getState() {
        return state;
    }

    private void createNature(List<List<VisibleEntity>> stateHolder) {

    }

    private void createPersons(List<List<VisibleEntity>> stateHolder) {
        List<VisibleEntity> persons = new ArrayList<VisibleEntity>();
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        stateHolder.add(persons);
    }
}
