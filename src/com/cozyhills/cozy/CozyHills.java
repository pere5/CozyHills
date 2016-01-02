package com.cozyhills.cozy;

import com.cozyhills.Util;
import com.cozyhills.model.Rule;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.map.person.EmptyRule;
import com.cozyhills.model.map.Person;

/**
 * Created by pere5 on 21/12/15.
 */
public class CozyHills {

    StateHolder stateHolder = StateHolder.instance();
    Rule selectedRule = new EmptyRule();

    public void update() {
        for (VisibleEntity visibleEntity : stateHolder.getPersons()) {
            Person person = (Person) visibleEntity;
            if (!person.working()) {
                int currentStatus = -1;
                Util.print("[");
                for (Rule rule : Person.getRules()) {
                    int newStatus = rule.calculate(person);
                    rule.printStatus(newStatus);
                    if (currentStatus < newStatus) {
                        currentStatus = newStatus;
                        selectedRule = rule;
                    }
                }
                Util.print("]");
                person.startWorking(selectedRule);
            } else {
                Util.print("[     ]");
            }
            person.work();
        }
    }
}
