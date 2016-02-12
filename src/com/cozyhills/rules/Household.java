package com.cozyhills.rules;

import com.cozyhills.actions.*;
import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.BasicHut;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.resources.Resource;

import java.util.Optional;
import java.util.Queue;

/**
 * Created by pere5 on 02/01/16.
 */
public class Household extends RuleHelper {

    private static final int NEIGHBORHOOD_ZONE = 120;
    private static final int VISIBLE_ZONE = 80;

    public Household(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        Optional<Home> myHome = me.getHome();
        if (myHome.isPresent()) {
            int result = 0;
            for (Home home: getHomes()) {
                double range = range(home, myHome.get()); //include my own home
                if (range < NEIGHBORHOOD_ZONE) {
                    result += home.getStatus();
                }
            }
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public void initWork(Person me, int status) {
        Queue<Action> actionQueue = me.getActionQueue();
        if (me.getHome().isPresent()) {
            improveHome(me, actionQueue);
        } else if (me.searchForHome()) {
            moveInToHome(me, actionQueue);
        } else {
            buildNewHut(me, actionQueue);
        }
    }

    private void buildNewHut(Person me, Queue<Action> actionQueue) {
        Optional<Item> carryingItem = me.getAnCarryingItemOfTypes(BasicHut.buildCost());
        if (carryingItem.isPresent()) {
            buildNewHut(me, carryingItem.get(), actionQueue);
        } else {
            Optional<Item> visibleItem = getClosestVisibleEntityOfTypeSet(me, VISIBLE_ZONE, BasicHut.buildCost().keySet());
            if (visibleItem.isPresent()) {
                pickUpItem(me, actionQueue, visibleItem);
            } else {
                gatherResource(me, actionQueue);
            }
        }
    }

    private void improveHome(Person me, Queue<Action> actionQueue) {
        Home home = me.getHome().get();
        if (!home.completed()) {
            Optional<Item> carryingItem = me.getAnCarryingItemOfTypes(home.remainingBuildCost());
            if (carryingItem.isPresent()) {
                continueConstruction(me, home, carryingItem.get(), actionQueue);
            } else {
                Optional<Item> visibleItem = getClosestVisibleEntityOfTypeSet(me, VISIBLE_ZONE, BasicHut.buildCost().keySet());
                if (visibleItem.isPresent()) {
                    pickUpItem(me, actionQueue, visibleItem);
                } else {
                    gatherResource(me, actionQueue);
                }
            }
        } else {
            improveExistingHome(actionQueue);
        }
    }

    private void improveExistingHome(Queue<Action> actionQueue) {
        Util.printNotImplemented("Household.improveExistingHome()");
        actionQueue.add(new Wait(10));
    }

    private void continueConstruction(Person me, Home home, Item item, Queue<Action> actionQueue) {
        actionQueue.add(new Path(me.xy, home.xy));
        actionQueue.add(new Build(home, item));
    }

    private void gatherResource(Person me, Queue<Action> actionQueue) {
        Optional<Resource> resource = getClosestVisibleResourceFromItemSet(me, VISIBLE_ZONE, BasicHut.buildCost().keySet());
        if (resource.isPresent()) {
            actionQueue.add(new DropCarrying());
            actionQueue.add(new Path(me.xy, resource.get().xy));
            actionQueue.add(new Gather(resource.get()));
        } else {
            actionQueue.add(new Path(me.xy, randomDestination(me, VISIBLE_ZONE / 2)));
        }
    }

    private void pickUpItem(Person me, Queue<Action> actionQueue, Optional<Item> item) {
        actionQueue.add(new Path(me.xy, item.get().xy));
        actionQueue.add(new PickUp(item.get()));
    }

    private void buildNewHut(Person me, Item item, Queue<Action> actionQueue) {
        if (me.getSafeSpot().isPresent()) {
            double[] safeSpot = me.getSafeSpot().get();
            actionQueue.add(new Path(me.xy, safeSpot));
            actionQueue.add(new Build(new BasicHut(safeSpot), item));
        } else {
            actionQueue.add(new Build(new BasicHut(me.xy), item));
        }
    }

    private void moveInToHome(Person me, Queue<Action> actionQueue) {
        Optional<Home> home = getClosestUnvisitedVisibleHome(me, VISIBLE_ZONE);
        if (home.isPresent()) {
            actionQueue.add(new Path(me.xy, home.get().xy));
            actionQueue.add(new MoveIn(home.get()));
        } else {
            actionQueue.add(new Path(me.xy, randomDestination(me, VISIBLE_ZONE / 2)));
        }
    }
}
