package com.cozyhills.rules;

import com.cozyhills.actions.Action;
import com.cozyhills.actions.Path;
import com.cozyhills.actions.PickUp;
import com.cozyhills.things.Person;
import com.cozyhills.things.items.Item;

import java.util.Optional;
import java.util.Queue;

/**
 * Created by periks15 on 2016-02-24.
 */
public class PickUpItem extends RuleHelper {

    public PickUpItem(int rank) {
        super(rank);
    }

    private void pickUpItem(Person me, Queue<Action> actionQueue, Optional<Item> item) {
        actionQueue.add(new Path(me.xy, item.get().xy));
        actionQueue.add(new PickUp(item.get()));
    }

    @Override
    public int calculateStatus(Person me) {
        return 0;
    }

    @Override
    public void initWork(Person me, int status) {

    }
}
