package com.cozyhills.model.map.person;

import com.cozyhills.Util;
import com.cozyhills.model.RuleHelper;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.idea.Path;
import com.cozyhills.model.map.Person;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pere5 on 02/01/16.
 */
public class StrengthInNumbers extends RuleHelper {

    private static final int comfortZone = 30;
    private static final int visibleZone = 80;

    @Override
    public int calculate(Person me) {
        int result = 0;
        List<VisibleEntity> persons = getPersons();
        me.clearTarget();
        for (VisibleEntity visibleEntity: persons) {
            Person person = (Person)visibleEntity;
            int range = person != me ? range(person, me): Integer.MAX_VALUE;
            if (range < comfortZone) {
                result += 1;
            }
            if (range < visibleZone) {
                me.addTarget(person);
            }
        }
        return result;
    }

    @Override
    public void initWork(Person me) {
        List<Person> targets = me.getTargets();
        int[] destination;
        if (targets.size() == 0) {
            int r1 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
            int r2 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
            destination = new int[] {me.x + 50 * r1, me.y + 50 * r2};
        } else {
            destination = centroid(targets);
        }
        me.setPath(new Path(new int[] {me.x, me.y}, destination));
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
