package com.cozyhills.rules;

import com.cozyhills.actions.Action;
import com.cozyhills.actions.Build;
import com.cozyhills.actions.Path;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;

import java.util.Queue;

/**
 * Created by periks15 on 2016-02-24.
 */
public class ContinueConstruction extends RuleHelper  {

    public ContinueConstruction(int rank) {
        super(rank);
    }

    private void continueConstruction(Person me, Home home, Item item, Queue<Action> actionQueue) {
        actionQueue.add(new Path(me.xy, home.xy));
        actionQueue.add(new Build(home, item));
    }

    @Override
    public int calculateStatus(Person me) {
        return 0;
    }

    @Override
    public void initWork(Person me, int status) {

    }
}
