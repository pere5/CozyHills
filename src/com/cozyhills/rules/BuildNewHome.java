package com.cozyhills.rules;

import com.cozyhills.actions.Action;
import com.cozyhills.actions.Build;
import com.cozyhills.actions.Path;
import com.cozyhills.rules.RuleHelper;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.BasicHut;
import com.cozyhills.things.items.Item;

import java.util.Queue;

/**
 * Created by periks15 on 2016-02-24.
 */
public class BuildNewHome extends RuleHelper {

    public BuildNewHome(int rank) {
        super(rank);
    }

    private void buildNewHut(Person me, Item item, Queue<Action> actionQueue) {
        if (me.getSafeSpot().isPresent()) {
            double[] safeSpot = me.getSafeSpot().get();
            BasicHut basicHut = new BasicHut(me, safeSpot);
            actionQueue.add(new Path(me.xy, safeSpot));
            actionQueue.add(new Build(basicHut, item));
        } else {
            BasicHut basicHut = new BasicHut(me, me.xy);
            actionQueue.add(new Build(basicHut, item));
        }
    }

    @Override
    public int calculateStatus(Person me) {
        return 0;
    }

    @Override
    public void initWork(Person me, int status) {

    }
}
