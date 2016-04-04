package com.cozyhills.rules;

import com.cozyhills.Const;
import com.cozyhills.actions.Action;
import com.cozyhills.actions.Path;
import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;

import java.awt.*;
import java.util.Queue;
import java.util.Set;

/**
 * Created by pere5 on 02/01/16.
 */
public class CozyUp extends RuleHelper {

    public CozyUp(int rank) {
        super(rank);
    }

    @Override
    public int assessStatus(Person me) {
        int result = 0;
        me.clearTarget();
        for (Person person: getPersons()) {
            double range = person != me ? range(person, me): Double.MAX_VALUE;
            if (range < Const.COMFORT_ZONE) {
                result += 1;
            }
            if (range < Const.VISIBLE_ZONE) {
                me.addTarget(person);
            }
        }
        final int ME = 1;
        final int MARGIN = 1;
        result -= (Const.COZY_GROUP - ME - MARGIN);
        if (result > 0) {
            me.safeSpot(me.xy);
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public void decideActions(Person me, int status) {
        Queue<Action> actionQueue = me.getActionQueue();
        Set<VisibleEntity> targets = me.getTargets();
        double[] destination;
        if (targets.size() == 0) {
            destination = randomDestination(me, Const.WALK_DISTANCE);
        } else if (status == 0) {
            destination = centroid(targets);
            if (me.xy[0] == destination[0] && me.xy[1] == destination[1]) {
                destination = randomDestination(me, Const.WALK_DISTANCE);
            }
        } else {
            destination = centroid(targets);
        }
        actionQueue.add(new Path(me.xy, destination));
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
