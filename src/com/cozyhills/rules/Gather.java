package com.cozyhills.rules;

import com.cozyhills.model.Person;
import com.cozyhills.rules.support.RuleHelper;

/**
 * Created by pere5 on 28/01/16.
 */
public class Gather extends RuleHelper {

    public Gather(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        return 0;
    }

    @Override
    public void initWork(Person me, int status) {

    }
}
