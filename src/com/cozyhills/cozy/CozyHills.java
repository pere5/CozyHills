package com.cozyhills.cozy;

import com.cozyhills.rules.*;
import com.cozyhills.things.Person;
import com.cozyhills.tribe.Tribe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pere5 on 21/12/15.
 */
public class CozyHills {

    private static final Set<Rule> rules = new HashSet<>();
    static {
        int rank = Integer.MAX_VALUE;
        rules.add(new HoneFood(--rank));
        rules.add(new HoneClothing(--rank));
        rules.add(new HoneLove(--rank));
        rules.add(new HoneSecurity(--rank));
        rules.add(new HoneSettlement(--rank));
        rules.add(new HoneReligon(--rank));
        rules.add(new HoneWealth(--rank));
    }
    private static final int TRIBE_FREQUENCY = 10;
    private static int counter = 0;

    public void update() {
        for (Person person : StateHolder.getPersons()) {
            boolean working = person.working();
            if (!working) {
                Rule selectedRule = null;
                int selectedRuleRank = Integer.MIN_VALUE;
                int currentStatus = Integer.MAX_VALUE;
                for (Rule newRule : rules) {
                    int newStatus = newRule.assessStatus(person);
                    if (newStatus < currentStatus || (newStatus == currentStatus && newRule.rank() > selectedRuleRank)) {
                        currentStatus = newStatus;
                        selectedRule = newRule;
                        selectedRuleRank = selectedRule.rank();
                    }
                }
                person.startWorking(selectedRule, currentStatus);
            }
            Util.print((working ? "  " : " >") + person.getCurrentRule().id());
            person.color = person.getCurrentRule().getColor();
            person.work();
        }

        //run a tenth of the tribes per frame
        List<Tribe> tribes = StateHolder.getTribes();
        int tenthOfCurrent = tribes.size() / 10;
        int roof = counter + tenthOfCurrent;
        roof = Math.min(roof, tribes.size());
        while (counter < roof) {
            counter++;
            Tribe tribe = tribes.get(counter);
            tribe.assessStatus();
            tribe.considerTribalUnification();
            tribe.considerTrade();
            tribe.considerWar();
            tribe.considerMigration();
            tribe.considerOccupations();
        }
        if (counter == tribes.size()) {
            counter = 0;
        }
    }
}
