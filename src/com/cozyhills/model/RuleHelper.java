package com.cozyhills.model;

import com.cozyhills.cozy.StateHolder;
import com.cozyhills.model.map.Person;
import com.cozyhills.model.map.person.StrengthInNumbers;

import java.util.List;

/**
 * Created by pere5 on 02/01/16.
 */
public abstract class RuleHelper implements Rule {

    protected int range(VisibleEntity visibleEntity, Person me) {
        return (int)Math.sqrt(Math.pow((visibleEntity.x - me.x), 2) + Math.pow((visibleEntity.y - me.y), 2));
    }

    protected int[] centroid(List<Person> persons) {
        int[] centroid = { 0, 0 };

        for (Person person: persons) {
            centroid[0] += person.x;
            centroid[1] += person.y;
        }

        int totalPoints = persons.size();
        centroid[0] = centroid[0] / totalPoints;
        centroid[1] = centroid[1] / totalPoints;

        return centroid;
    }

    public List<VisibleEntity> getPersons() {
        return StateHolder.instance().getPersons();
    }
}
