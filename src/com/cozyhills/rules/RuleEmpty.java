package com.cozyhills.rules;

import com.cozyhills.things.Person;

/**
 * Created by pere5 on 02/01/16.
 */
public class RuleEmpty extends RuleHelper {

    public RuleEmpty() {
        super(Integer.MAX_VALUE);
    }

    @Override
    public int calculateStatus(Person me) {
        return Integer.MAX_VALUE;
    }

    @Override
    public void initWork(Person me, int status) {

    }
}
