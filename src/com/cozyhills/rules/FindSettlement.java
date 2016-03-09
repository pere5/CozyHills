package com.cozyhills.rules;

import com.cozyhills.Const;
import com.cozyhills.actions.Action;
import com.cozyhills.actions.Path;
import com.cozyhills.things.Person;
import com.cozyhills.things.VisibleEntity;
import com.cozyhills.things.ideas.MudVillage;

import java.util.Queue;
import java.util.Set;

/**
 * Created by pere5 on 02/01/16.
 */
public class FindSettlement extends RuleHelper {

    public FindSettlement(int rank) {
        super(rank);
    }

    /*
     *  What is status for FindSettlement?
     *
     *  It is the status of the settlement or of none, zero.
     */

    @Override
    public int calculateStatus(Person me) {
        if (me.getSettlement().isPresent()) {
            return me.getSettlement().get().getStatus();
        } else {
            return 0;
        }
    }

    /*
     *  What is work for FindSettlement?
     *
     *  Search for people and join their settlement.
     *  If they have no settlement, create a new Settlement.
     */

    @Override
    public void initWork(Person me, int status) {

        int result = 0;
        me.clearTarget();
        for (Person person: getPersons()) {
            double range = person != me ? range(person, me): Double.MAX_VALUE;
            if (range < Const.TALKING_DISTANCE) {
                result += 1;
            }
            if (range < Const.VIEWABLE_DISTANCE) {
                me.addTarget(person);
            }
        }
        final int ME = 1;
        final int MARGIN = 1;
        result -= (Const.COZY_GROUP - ME - MARGIN);
        if (result > 0) {
            me.setSettlement(new MudVillage());
            //return result;
        } else {
            //return 0;
        }

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
}
