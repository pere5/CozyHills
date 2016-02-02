package com.cozyhills.cozy;

import com.cozyhills.things.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pere5 on 23/12/15.
 */
public class StateHolder {

    private static int idGenerator = 0;

    private static StateHolder instance = new StateHolder();
    Map<Class<?>, Set<? extends VisibleEntity>> state = new HashMap<>();

    public StateHolder() {
        createPersons();
        createTrees();
        createRocks();

        state.put(Home.class, new HashSet<Home>());
    }

    public static StateHolder instance() {
        return instance;
    }

    public Map<Class<?>, Set<? extends VisibleEntity>> getState() {
        return state;
    }

    private void createTrees() {
        Set<VisibleEntity> trees = new HashSet<>();
        for (int i = 0; i < 40; i++) {
            trees.add(new Tree());
        }
        state.put(Tree.class, trees);
    }

    private void createRocks() {
        Set<VisibleEntity> rocks = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            rocks.add(new Rock());
        }
        state.put(Rock.class, rocks);
    }

    private void createPersons() {
        Set<VisibleEntity> persons = new HashSet<>();
        for (int i = 0; i < 40; i++) {
            persons.add(new Person());
        }
        state.put(Person.class, persons);
    }

    public Set<Person> getPersons() {
        return (Set<Person>)state.get(Person.class);
    }

    public Set<Home> getHomes() {
        return (Set<Home>)state.get(Home.class);
    }

    public Set<Tree> getTrees() {
        return (Set<Tree>)state.get(Tree.class);
    }

    public Set<Rock> getRocks() {
        return (Set<Rock>)state.get(Rock.class);
    }

    public Set<? extends VisibleEntity> getEntities(Class<?> classType) {
        return state.get(classType);
    }

    public static int getNewId() {
        return idGenerator++;
    }
}
