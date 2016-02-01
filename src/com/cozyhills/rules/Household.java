package com.cozyhills.rules;

import com.cozyhills.actions.*;
import com.cozyhills.model.*;
import com.cozyhills.rules.support.RuleHelper;

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
        } else if (me.searchForHome()) {
            Home closestUnvisitedHome = getClosestUnvisitedVisibleHome(me.getVisitedHomes(), VISIBLE_ZONE);
            if (closestUnvisitedHome != null) {
                actionQueue.add(new Path(me.xy, closestUnvisitedHome.xy));
                actionQueue.add(new MoveIn(closestUnvisitedHome));
            } else {
                actionQueue.add(new Path(me.xy, randomDestination(me, VISIBLE_ZONE)));
            }
        } else if (me.hasEnoughResources(BasicHut.buildCost())) {
            actionQueue.add(new Build(BasicHut.class));
        } else {
            actionQueue.add(new Gather(me.getResources(), BasicHut.buildCost()));
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
