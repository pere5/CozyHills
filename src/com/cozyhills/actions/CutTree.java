package com.cozyhills.actions;

import com.cozyhills.model.Person;

import java.util.Queue;

/**
 * Created by pere5 on 14/01/16.
 */
public class CutTree implements Action {

    private int cut = 10;

    @Override
    public boolean doIt(Person me, Queue<Action> actionQueue) {
        cut--;
        reuturn cut <= 0;
    }

    private void cut() {
        cut--;
    }
}
