package com.cozyhills.cozy;

import com.cozyhills.things.*;
import com.cozyhills.things.buildings.BasicHut;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Clothes;
import com.cozyhills.things.items.Food;
import com.cozyhills.things.items.Stone;
import com.cozyhills.things.items.Wood;
import com.cozyhills.things.resources.Rock;
import com.cozyhills.things.resources.Tree;

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

        createHomes();

        state.put(Clothes.class, new HashSet<Clothes>());
        state.put(Food.class, new HashSet<Food>());
        state.put(Stone.class, new HashSet<Stone>());
        state.put(Wood.class, new HashSet<Wood>());
    }

    public static StateHolder instance() {
        return instance;
    }

    public Map<Class<?>, Set<? extends VisibleEntity>> getState() {
        return state;
    }


    private void createHomes() {
        Set<Home> homes = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            homes.add(new BasicHut());
        }
        state.put(Home.class, homes);
    }

    private void createTrees() {
        Set<Tree> trees = new HashSet<>();
        for (int i = 0; i < 40; i++) {
            trees.add(new Tree());
        }
        state.put(Tree.class, trees);
    }

    private void createRocks() {
        Set<Rock> rocks = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            rocks.add(new Rock());
        }
        state.put(Rock.class, rocks);
    }

    private void createPersons() {
        Set<Person> persons = new HashSet<>();
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
