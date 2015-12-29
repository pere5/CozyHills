package com.cozyhills.cozy;

import com.cozyhills.model.GameType;
import com.cozyhills.model.major.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pere5 on 23/12/15.
 */
public class StateHolder {
    List<List<GameType>> stateHolder = new ArrayList<List<GameType>>();

    public StateHolder() {
        createPersons(stateHolder);
        createNature(stateHolder);
    }

    private void createNature(List<List<GameType>> stateHolder) {

    }

    private void createPersons(List<List<GameType>> stateHolder) {
        List<GameType> persons = new ArrayList<GameType>();
        persons.add(new Person(400, 300));
        persons.add(new Person(403, 303));
        persons.add(new Person(410, 310));
        persons.add(new Person(390, 310));
        persons.add(new Person(400, 290));
        persons.add(new Person(410, 290));
        stateHolder.add(persons);
    }

    public List<List<GameType>> getState() {
        return stateHolder;
    }
}
