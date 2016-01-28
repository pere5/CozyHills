package com.cozyhills.rules;

import com.cozyhills.actions.Action;
import com.cozyhills.actions.CutTree;
import com.cozyhills.actions.Path;
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
                Home otherHome = (Home)visibleEntity;
                int range = otherHome != myHome ? range(otherHome, myHome): Integer.MAX_VALUE;
                if (range < NEIGHBORHOOD_ZONE) {
                    result += otherHome.getStatus();
                }
            }
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public void initWork(Person me, int status, Queue<Action> actionQueue) {

        if (status == 0) {
            //build new home
            Tree closestTree = getClosestVisibleTree(me, VISIBLE_ZONE);
            Rock closestRock = getClosestVisibleRock(me, VISIBLE_ZONE);
            if (closestTree == null) {
                int[] destination;
                destination = randomDestination(me, VISIBLE_ZONE);
                actionQueue.add(new Path(new int[]{me.x, me.y}, destination));
            } else {
                actionQueue.add(new Path(new int[] {me.x, me.y}, new int[] {closestTree.x, closestTree.y}));
                actionQueue.add(new CutTree(closestTree));
            }
        } else {
            //improve home

        }
    }
}
