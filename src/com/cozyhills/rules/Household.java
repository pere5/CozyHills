package com.cozyhills.rules;

import com.cozyhills.actions.Path;
import com.cozyhills.actions.WaitForever;
import com.cozyhills.cozy.Util;
import com.cozyhills.model.Person;
import com.cozyhills.model.Home;
import com.cozyhills.model.Tree;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.actions.Action;
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
            Tree closestTree = null;
            Integer closestRange = Integer.MAX_VALUE;
            int[] destination;
            for (VisibleEntity visibleEntity: getTrees()) {
                Tree tree = (Tree)visibleEntity;
                int range = range(me, tree);
                if (range < closestRange) {
                    closestRange = range;
                    closestTree = tree;
                }
            }
            if (closestRange > VISIBLE_ZONE || closestTree == null) {
                destination = randomDestination(me, VISIBLE_ZONE);
                actionQueue.add(new Path(new int[] {me.x, me.y}, destination));
            } else {
                destination = new int[] {closestTree.x, closestTree.y};
                actionQueue.add(new Path(new int[] {me.x, me.y}, destination));
                actionQueue.add(new WaitForever());
            }
        } else {
            //improve home

        }
    }
}
