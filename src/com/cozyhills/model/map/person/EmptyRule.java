package com.cozyhills.model.map.person;

import com.cozyhills.model.RuleHelper;
import com.cozyhills.model.map.Person;

/**
 * Created by pere5 on 02/01/16.
 */
public class EmptyRule extends RuleHelper {

    @Override
    public int calculate(Person me) {
        return 0;
    }

    public boolean work(Person person) {
        return false;
    }

    @Override
    public void printStatus(int newStatus) {

    }
}
