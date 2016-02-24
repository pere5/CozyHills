package com.cozyhills.rules;

import com.cozyhills.rules.RuleHelper;
import com.cozyhills.things.Person;

/**
 * Created by periks15 on 2016-02-24.
 */
public class SearchForHome extends RuleHelper {
    public SearchForHome(int rank) {
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
