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

    private static int idGenerator = 0;

    private static StateHolder instance = new StateHolder();
    Map<Class<?>, List<? extends VisibleEntity>> state = new HashMap<>();

    public StateHolder() {
        createPersons();
        createTrees();
        createRocks();
    }

    public static StateHolder instance() {
        return instance;
    }

    public Map<Class<?>, List<? extends VisibleEntity>> getState() {
        return state;
    }

    private void createTrees() {
        List<VisibleEntity> trees = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            trees.add(new Tree());
        }
        state.put(Tree.class, trees);
    }

    private void createRocks() {
        List<VisibleEntity> rocks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            rocks.add(new Rock());
        }
        state.put(Rock.class, rocks);
    }

    private void createPersons() {
        List<VisibleEntity> persons = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            persons.add(new Person());
        }
        state.put(Person.class, persons);
    }

    public List<Person> getPersons() {
        return (List<Person>)state.get(Person.class);
    }

    public List<Home> getHomes() {
        return (List<Home>)state.get(Home.class);
    }

    public List<Tree> getTrees() {
        return (List<Tree>)state.get(Tree.class);
    }

    public List<Rock> getRocks() {
        return (List<Rock>)state.get(Rock.class);
    }

    public List<? extends VisibleEntity> getEntities(Class<?> classType) {
        return state.get(classType);
    }

    public int getNewId() {
        return idGenerator++;
    }
}
