package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.model.Person;

import java.util.Queue;

/**
 * Created by pere5 on 14/01/16.
 */
public class Wait implements Action {

    @Override
    public boolean doIt(Person me, Queue<Action> actionQueue) {
        Wait wait = (Wait)actionQueue.poll();
        return wait != null;
    }
}
