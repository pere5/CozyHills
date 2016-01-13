package com.cozyhills.rules;

import com.cozyhills.cozy.Util;
import com.cozyhills.model.Person;
import com.cozyhills.model.Home;

/**
 * Created by pere5 on 02/01/16.
 */
public class SeekShelter extends RuleHelper {

    public SeekShelter(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        Home home = me.getHome();
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
