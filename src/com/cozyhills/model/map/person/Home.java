package com.cozyhills.model.map.person;

import com.cozyhills.Util;
import com.cozyhills.model.RuleHelper;
import com.cozyhills.model.map.Person;

/**
 * Created by pere5 on 02/01/16.
 */
public class Home extends RuleHelper {

    public Home(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        return 0;
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
