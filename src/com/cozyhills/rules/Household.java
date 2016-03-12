package com.cozyhills.rules;

import com.cozyhills.Const;
import com.cozyhills.actions.*;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Hut;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.resources.Resource;

import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 * Created by pere5 on 02/01/16.
 */
public class Household extends RuleHelper {

    public Household(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        Optional<Home> myHome = me.getHome();
        if (myHome.isPresent() && myHome.get().completed()) {
            int result = 0;
            for (Home home: getHomes()) {
                double range = range(home, myHome.get()); //include my own home
                if (range < Const.NEIGHBORHOOD_ZONE) {
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
            searchForHome(me, actionQueue);
        } else {
            buildNewHut(me, actionQueue);
        }
    }

    //-----------------------------------------------------------

    private void improveHome(Person me, Queue<Action> actionQueue) {
        Home home = me.getHome().get();
        if (!home.completed()) {
            Map<Class<? extends Item>, Integer> remainingBuildCost = home.remainingBuildCost();
            Optional<Item> carryingItem = me.getAnCarryingItemOfTypes(remainingBuildCost);
            if (carryingItem.isPresent()) {
                continueConstruction(me, home, carryingItem.get(), actionQueue);
            } else {
                Optional<Item> visibleItem = (Optional<Item>) getClosestVisibleEntityOfTypeSet(me, Const.VISIBLE_ZONE, remainingBuildCost.keySet());
                if (visibleItem.isPresent()) {
                    pickUpItem(me, actionQueue, visibleItem);
                } else {
                    gatherResource(me, remainingBuildCost.keySet(), actionQueue);
                }
            }
        } else {
            improveExistingHome(actionQueue);
        }
    }

    private void searchForHome(Person me, Queue<Action> actionQueue) {
        Optional<Home> home = getClosestUnvisitedVisibleHome(me, Const.VISIBLE_ZONE);
        if (home.isPresent()) {
            actionQueue.add(new Path(me.xy, home.get().xy));
            actionQueue.add(new MoveIn(home.get()));
        } else {
            actionQueue.add(new Path(me.xy, randomDestination(me, Const.VISIBLE_ZONE / 2)));
        }
    }

    private void buildNewHut(Person me, Queue<Action> actionQueue) {
        Optional<Item> carryingItem = me.getAnCarryingItemOfTypes(Hut.buildCost());
        if (carryingItem.isPresent()) {
            buildNewHut(me, carryingItem.get(), actionQueue);
        } else {
            Optional<Item> visibleItem = (Optional<Item>) getClosestVisibleEntityOfTypeSet(me, Const.VISIBLE_ZONE, Hut.buildCost().keySet());
            if (visibleItem.isPresent()) {
                pickUpItem(me, actionQueue, visibleItem);
            } else {
                gatherResource(me, Hut.buildCost().keySet(), actionQueue);
            }
        }
    }

    //-----------------------------------------------------------

    private void improveExistingHome(Queue<Action> actionQueue) {
        //Util.printNotImplemented("Household.improveExistingHome()");
        actionQueue.add(new Wait(10));
    }

    private void continueConstruction(Person me, Home home, Item item, Queue<Action> actionQueue) {
        actionQueue.add(new Path(me.xy, home.xy));
        actionQueue.add(new Build(home, item));
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

    private void pickUpItem(Person me, Queue<Action> actionQueue, Optional<Item> item) {
        actionQueue.add(new Path(me.xy, item.get().xy));
        actionQueue.add(new PickUp(item.get()));
    }

    private void buildNewHut(Person me, Item item, Queue<Action> actionQueue) {
        if (me.getSafeSpot().isPresent()) {
            double[] safeSpot = me.getSafeSpot().get();
            Hut hut = new Hut(me, safeSpot);
            actionQueue.add(new Path(me.xy, safeSpot));
            actionQueue.add(new Build(hut, item));
        } else {
            Hut hut = new Hut(me, me.xy);
            actionQueue.add(new Build(hut, item));
        }
    }
}
