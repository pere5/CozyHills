package com.cozyhills.cozy;

import com.cozyhills.model.*;

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
    Map<String, List<? extends VisibleEntity>> state = new HashMap<>();

    public StateHolder() {
        createPersons(state);
        createNature(state);
    }

    public static StateHolder instance() {
        return instance;
    }

    public Map<String, List<? extends VisibleEntity>> getState() {
        return state;
    }

    private void createNature(Map<String, List<? extends VisibleEntity>> stateHolder) {
        createTrees(stateHolder);
        createRocks(stateHolder);
    }

    private void createTrees(Map<String, List<? extends VisibleEntity>> stateHolder) {
        List<VisibleEntity> trees = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            trees.add(new Tree());
        }
        stateHolder.put(TREES, trees);
    }

    private void createRocks(Map<String, List<? extends VisibleEntity>> stateHolder) {
        List<VisibleEntity> rocks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            rocks.add(new Rock());
        }
        stateHolder.put(ROCKS, rocks);
    }

    private void createPersons(Map<String, List<? extends VisibleEntity>> stateHolder) {
        List<VisibleEntity> persons = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            persons.add(new Person());
        }
        stateHolder.put(PERSONS, persons);
    }

    public List<Person> getPersons() {
        return (List<Person>)state.get(PERSONS);
    }

    public List<Home> getHomes() {
        return (List<Home>)state.get(HOMES);
    }

    public List<Tree> getTrees() {
        return (List<Tree>)state.get(TREES);
    }

    public List<Rock> getRocks() {
        return (List<Rock>)state.get(ROCKS);
    }

    public List<? extends VisibleEntity> getEntities(String entity) {
        return state.get(entity);
    }
}
