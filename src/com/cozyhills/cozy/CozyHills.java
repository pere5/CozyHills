package com.cozyhills.cozy;

import com.cozyhills.rules.CozyUp;
import com.cozyhills.rules.EmptyRule;
import com.cozyhills.rules.Rule;
import com.cozyhills.model.VisibleEntity;
import com.cozyhills.model.Person;
import com.cozyhills.rules.SeekShelter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pere5 on 21/12/15.
 */
public class CozyHills {

    public static List<Rule> rules = new ArrayList<>();
    static {
        int rank = Integer.MAX_VALUE;
        rules.add(new CozyUp(--rank));
        rules.add(new SeekShelter(--rank));
    }

    StateHolder stateHolder = StateHolder.instance();
    Rule selectedRule = new EmptyRule();

    public void update() {
        for (VisibleEntity visibleEntity : stateHolder.getPersons()) {
            Person person = (Person) visibleEntity;
            if (!person.working()) {
                int currentStatus = Integer.MAX_VALUE;
                Util.print("[");
                for (Rule newRule : rules) {
                    int newStatus = newRule.calculateStatus(person);
                    newRule.printStatus(newStatus);
                    if (newStatus < currentStatus || (newStatus == currentStatus && newRule.rank() > selectedRule.rank())) {
                        currentStatus = newStatus;
                        selectedRule = newRule;
                    }
                }
                Util.print("]");
                person.startWorking(selectedRule, currentStatus);
            } else {
                Util.print("[     ]");
            }
            person.work();
        }
    }
}
