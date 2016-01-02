package com.cozyhills.model.map.person;

import com.cozyhills.model.RuleHelper;
import com.cozyhills.model.map.Person;

import java.util.List;

/**
 * Created by pere5 on 02/01/16.
 */
public class EmptyRule extends RuleHelper {

    @Override
    public int calculate(Person me) {
        return 0;
    }

    @Override
    public boolean work(Person person, List<Person> targets) {
        return false;
    }

    @Override
    public void printStatus(int newStatus) {

    }
}
