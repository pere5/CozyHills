package com.cozyhills.cozy;

import com.cozyhills.rules.CozyUp;
import com.cozyhills.rules.EmptyRule;
import com.cozyhills.rules.Household;
import com.cozyhills.rules.Rule;
import com.cozyhills.things.Person;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pere5 on 21/12/15.
 */
public class CozyHills {

    private static final Set<Rule> rules = new HashSet<>();
    static {
        int rank = Integer.MAX_VALUE;
        rules.add(new CozyUp(--rank));
        rules.add(new Household(--rank));
    }

    Rule selectedRule = new EmptyRule();

    public void update() {
        for (Person person : StateHolder.getPersons()) {
            boolean working = person.working();
            if (!working) {
                int currentStatus = Integer.MAX_VALUE;
                for (Rule newRule : rules) {
                    int newStatus = newRule.calculateStatus(person);
                    if (newStatus < currentStatus || (newStatus == currentStatus && newRule.rank() > selectedRule.rank())) {
                        currentStatus = newStatus;
                        selectedRule = newRule;
                    }
                }
                person.startWorking(selectedRule, currentStatus);
            }
            Util.print((working ? "  " : " >") + person.getCurrentRule().id());
            person.color = person.getCurrentRule().getColor();
            person.work();
        }
    }
}
