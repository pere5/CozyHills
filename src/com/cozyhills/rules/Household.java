package com.cozyhills.rules;

import com.cozyhills.cozy.Util;
import com.cozyhills.actions.Path;
import com.cozyhills.model.Person;
import com.cozyhills.model.Home;
import com.cozyhills.model.Tree;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.actions.Action;
import com.cozyhills.rules.support.HomeLocation;
import com.cozyhills.rules.structure.RuleHelper;

import java.util.List;
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
    public Queue<Action> initWork(Person me, int status) {
        if (status == 0) {
            //build new home
            me.setHomeLocation(new HomeLocation(me.x, me.y));
            Tree closestTree = null;
            int closestRange = Integer.MAX_VALUE;
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
            } else {
                destination = new int[] {closestTree.x, closestTree.y};
            }
            me.setPath(new Path(new int[] {me.x, me.y}, destination));
        } else {
            //improve home
        }
        return null;
    }

    @Override
    public boolean work(Person me) {
        return false;
    }

    @Override
    public void printStatus(int status) {
        Util.print(status);
    }
}
