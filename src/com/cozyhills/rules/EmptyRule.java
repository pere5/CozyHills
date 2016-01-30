package com.cozyhills.rules;

import com.cozyhills.model.Person;
import com.cozyhills.rules.support.RuleHelper;

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
}
