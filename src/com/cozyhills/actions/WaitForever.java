package com.cozyhills.actions;

import com.cozyhills.model.Person;

import java.util.Queue;

/**
 * Created by pere5 on 14/01/16.
 */
public class WaitForever implements Action {

    @Override
    public boolean doIt(Person me, Queue<Action> actionQueue) {
        return true;
    }
}
