package com.cozyhills.rules;

import com.cozyhills.Const;
import com.cozyhills.actions.Action;
import com.cozyhills.actions.DropCarrying;
import com.cozyhills.actions.Gather;
import com.cozyhills.actions.Path;
import com.cozyhills.things.Person;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.resources.Resource;

import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 * Created by periks15 on 2016-02-24.
 */
public class GatherResource extends RuleHelper {

    public GatherResource(int rank) {
        super(rank);
    }

    private void gatherResource(Person me, Set<Class<? extends Item>> buildItems, Queue<Action> actionQueue) {
        Optional<Resource> resource = getClosestVisibleResourceFromItemSet(me, Const.VISIBLE_ZONE, buildItems);
        if (resource.isPresent()) {
            actionQueue.add(new DropCarrying());
            actionQueue.add(new Path(me.xy, resource.get().xy));
            actionQueue.add(new Gather(resource.get()));
        } else {
            actionQueue.add(new Path(me.xy, randomDestination(me, Const.VISIBLE_ZONE / 2)));
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
