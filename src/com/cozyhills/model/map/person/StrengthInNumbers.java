package com.cozyhills.model.map.person;

import com.cozyhills.Util;
import com.cozyhills.model.RuleHelper;
import com.cozyhills.model.VisibleEntity;
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

    public boolean work(Person person) {
        List<Person> targets = person.getTargets();
        if (targets.size() == 0) {
            int r1 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
            int r2 = 1 - ThreadLocalRandom.current().nextInt(0, 2 + 1);
            person.x = person.x + 3 * r1;
            person.y = person.y + 3 * r2;
        } else {
            int[] centroid = centroid(targets);
            person.x = person.x + 3 * (centroid[0] - person.x > 0 ? 1 : -1);
            person.y = person.y + 3 * (centroid[1] - person.y > 0 ? 1 : -1);
        }
        return false;
    }

    @Override
    public void printStatus(int status) {
        Util.print(status);
    }
}
