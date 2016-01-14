package com.cozyhills.rules;

import com.cozyhills.cozy.Util;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.actions.Path;
import com.cozyhills.model.Person;
import com.cozyhills.actions.Action;
import com.cozyhills.rules.structure.RuleHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by pere5 on 02/01/16.
 */
public class CozyUp extends RuleHelper {

    private static final int COMFORT_ZONE = 20;
    private static final int VISIBLE_ZONE = 80;
    private static final int SEARCH_DISTANCE = 20;
    private static final int COZY_GROUP = 4;

    public CozyUp(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        int result = 0;
        List<VisibleEntity> persons = getPersons();
        me.clearTarget();
        for (VisibleEntity visibleEntity: persons) {
            Person person = (Person)visibleEntity;
            int range = person != me ? range(person, me): Integer.MAX_VALUE;
            if (range < COMFORT_ZONE) {
                result += 1;
            }
            if (range < VISIBLE_ZONE) {
                me.addTarget(person);
            }
        }
        final int ME = 1;
        final int MARGIN = 1;
        result -= (COZY_GROUP - ME - MARGIN);
        return result > 0 ? result : 0;
    }

    @Override
    public Queue<Action> initWork(Person me, int status, Queue<Action> actionQueue) {
        List<VisibleEntity> targets = me.getTargets();
        int[] destination;
        if (targets.size() == 0) {
            destination = randomDestination(me, SEARCH_DISTANCE);
        } else if (status == 0) {
            destination = centroid(targets);
            if (me.x == destination[0] && me.y == destination[1]) {
                destination = randomDestination(me, SEARCH_DISTANCE);
            }
        } else {
            destination = centroid(targets);
        }
        Action path = new Path(new int[] {me.x, me.y}, destination);
        actionQueue.add(path);
        return actionQueue;
    }

    @Override
    public boolean work(Person me, Queue<Action> actionQueue) {
        Path path = (Path) actionQueue.peek();
        int[] step = path.nextStep();
        me.x = step[0];
        me.y = step[1];
        if (path.canContinue()) {
            return true;
        } else {
            actionQueue.poll();
            return false;
        }
    }

    @Override
    public void printStatus(int status) {
        Util.print(status);
    }
}
