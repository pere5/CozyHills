package com.cozyhills.rules;

import com.cozyhills.actions.*;
import com.cozyhills.cozy.Util;
import com.cozyhills.rules.support.RuleHelper;
import com.cozyhills.things.BasicHut;
import com.cozyhills.things.Home;
import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;

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
        Home myHome = me.getHome();
        if (myHome.exists()) {
            int result = 0;
            for (VisibleEntity visibleEntity: getHomes()) {
                Home someHome = (Home)visibleEntity;
                int range = range(someHome, myHome); //include my own home
                if (range < NEIGHBORHOOD_ZONE) {
                    result += someHome.getStatus();
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
        if (me.getHome().exists()) {
            //improve home: end
            actionQueue.add(new Wait(10));
            Util.print("NOT IMPLEMENTED, improve home!");
        } else if (me.searchForHome()) {
            Optional<Home> closestUnvisitedHome = getClosestUnvisitedVisibleHome(me, VISIBLE_ZONE);
            if (closestUnvisitedHome.isPresent()) {
                actionQueue.add(new Path(me.xy, closestUnvisitedHome.get().xy));
                actionQueue.add(new MoveIn(closestUnvisitedHome.get()));
            } else {
                actionQueue.add(new Path(me.xy, randomDestination(me, VISIBLE_ZONE * 2)));
            }
        } else {
            Optional<VisibleEntity> resource = hasAResource(me, BasicHut.buildCost());
            if (resource.isPresent()) {
                actionQueue.add(new Path(me.xy, resource.get().xy));
                actionQueue.add(new PickUp(resource.get()));
                actionQueue.add(new Path(resource.get().xy, me.xy));
                actionQueue.add(new Build(BasicHut.class, resource.get()));
            } else {
                actionQueue.add(new Gather(BasicHut.buildCost()));
            }
        }
    }
}

/*
                //build
        Tree closestTree = getClosestVisibleTree(me, VISIBLE_ZONE);
        if (closestTree == null) {
            int[] destination;
            destination = randomDestination(me, VISIBLE_ZONE);
            actionQueue.add(new Path(me.xy, destination));
        } else {
            actionQueue.add(new Path(me.xy, closestTree.xy));
            actionQueue.add(new CutTree(closestTree));
            actionQueue.add(new Path(closestTree.xy, me.xy));
        }
    }
}
*/
