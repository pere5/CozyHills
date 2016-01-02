package com.cozyhills.cozy;

import com.cozyhills.model.Rule;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.EmptyRule;
import com.cozyhills.model.map.Person;

import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class CozyHills {

    StateHolder stateHolder = new StateHolder();

    public void update() {
        for (VisibleEntity visibleEntity : stateHolder.getPersons()) {
            Person person = (Person) visibleEntity;
            int currentStatus = -1;
            Rule selectedRule = new EmptyRule();
            for (Rule rule: person.getRules()) {
                int newStatus = rule.calculate();
                if (currentStatus < newStatus) {
                    currentStatus = newStatus;
                    selectedRule = rule;
                }
            }
            //person.calculateStatus();
        }
    }

    public List<List<VisibleEntity>> getState() {
        return stateHolder.getState();
    }
}
