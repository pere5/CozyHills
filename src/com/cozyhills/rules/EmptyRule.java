package com.cozyhills.rules;

import com.cozyhills.cozy.Util;
import com.cozyhills.model.Person;

/**
 * Created by pere5 on 02/01/16.
 */
public class EmptyRule extends RuleHelper {

    public EmptyRule() {
        super(Integer.MAX_VALUE);
    }

    @Override
    public int calculateStatus(Person me) {
        return Integer.MAX_VALUE;
    }

    @Override
    public void initWork(Person me, int status) {

    }

    @Override
    public boolean work(Person me) {
        return false;
    }

    @Override
    public void printStatus(int status) {
        Util.print(status);
    }
}
