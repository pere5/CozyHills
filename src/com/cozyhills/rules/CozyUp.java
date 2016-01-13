package com.cozyhills.rules;

import com.cozyhills.cozy.Util;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.idea.Path;
import com.cozyhills.model.Person;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pere5 on 02/01/16.
 */
public class CozyUp extends RuleHelper {

    private static final int COMFORT_ZONE = 20;
    private static final int VISIBLE_ZONE = 80;
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
    public void initWork(Person me, int status) {
        List<Person> targets = me.getTargets();
        int[] destination;
        if (targets.size() == 0) {
            destination = randomDestination(me);
        } else if (status == 0) {
            destination = centroid(targets);
            if (me.x == destination[0] && me.y == destination[1]) {
                destination = randomDestination(me);
            }
        } else {
            destination = centroid(targets);
        }
        me.setPath(new Path(new int[] {me.x, me.y}, destination));
    }

    private int[] randomDestination(Person me) {
        int r1 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
        int r2 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
        return new int[]{me.x + 20 * r1, me.y + 20 * r2};
    }

    @Override
    public boolean work(Person me) {
        Path path = me.getPath();
        int[] step = path.nextStep();
        me.x = step[0];
        me.y = step[1];
        return path.canContinue();
    }

    @Override
    public void printStatus(int status) {
        Util.print(status);
    }
}
