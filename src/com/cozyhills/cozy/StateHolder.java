package com.cozyhills.cozy;

import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.map.Person;
import com.cozyhills.model.nature.Rock;
import com.cozyhills.model.nature.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pere5 on 23/12/15.
 */
public class StateHolder {

    private static StateHolder instance = new StateHolder();
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
        createTrees(stateHolder);
        createRocks(stateHolder);
    }

    private void createTrees(List<List<VisibleEntity>> stateHolder) {
        List<VisibleEntity> trees = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            trees.add(new Tree());
        }
        stateHolder.add(trees);
    }

    private void createRocks(List<List<VisibleEntity>> stateHolder) {
        List<VisibleEntity> rocks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            rocks.add(new Rock());
        }
        stateHolder.add(rocks);
    }

    private void createPersons(List<List<VisibleEntity>> stateHolder) {
        List<VisibleEntity> persons = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            persons.add(new Person());
        }
        stateHolder.add(persons);
    }

    public static StateHolder instance() {
        return instance;
    }
}
