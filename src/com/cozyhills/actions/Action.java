package com.cozyhills.actions;

import com.cozyhills.model.Person;

import java.util.Queue;

/**
 * Created by periks15 on 2016-01-14.
 */
public interface Action {

    boolean doIt(Person me, Queue<Action> actionQueue);
}
