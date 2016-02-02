package com.cozyhills.actions;

import com.cozyhills.model.Person;

import java.util.Map;

/**
 * Created by pere5 on 31/01/16.
 */
public class Gather implements Action {
    private final Map<Class<?>, Integer> goal;
    public Gather(Map<Class<?>, Integer> goal) {
        this.goal = goal;
    }

    @Override
    public boolean doIt(Person me) {

        return false;
    }
}
