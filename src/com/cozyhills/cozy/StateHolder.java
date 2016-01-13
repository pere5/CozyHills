package com.cozyhills.cozy;

import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.Person;
import com.cozyhills.model.Rock;
import com.cozyhills.model.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pere5 on 23/12/15.
 */
public class StateHolder {

    public static final String PERSONS = "persons";
    public static final String ROCKS = "rocks";
    public static final String TREES = "trees";
    public static final String HOMES = "homes";
    private static StateHolder instance = new StateHolder();
    Map<String, List<VisibleEntity>> state = new HashMap<>();

    public StateHolder() {
        createPersons(state);
        createNature(state);
    }

    public static StateHolder instance() {
        return instance;
    }

    public Map<String, List<VisibleEntity>> getState() {
        return state;
    }

    private void createNature(Map<String, List<VisibleEntity>> stateHolder) {
        createTrees(stateHolder);
        createRocks(stateHolder);
    }

    private void createTrees(Map<String, List<VisibleEntity>> stateHolder) {
        List<VisibleEntity> trees = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            trees.add(new Tree());
        }
        stateHolder.put(TREES, trees);
    }

    private void createRocks(Map<String, List<VisibleEntity>> stateHolder) {
        List<VisibleEntity> rocks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            rocks.add(new Rock());
        }
        stateHolder.put(ROCKS, rocks);
    }

    private void createPersons(Map<String, List<VisibleEntity>> stateHolder) {
        List<VisibleEntity> persons = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            persons.add(new Person());
        }
        stateHolder.put(PERSONS, persons);
    }

    public List<VisibleEntity> getPersons() {
        return state.get(PERSONS);
    }

    public List<VisibleEntity> getHomes() {
        return state.get(HOMES);
    }
}
