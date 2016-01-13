package com.cozyhills.rules;

import com.cozyhills.cozy.Util;
import com.cozyhills.model.Person;
import com.cozyhills.model.Home;
import com.cozyhills.model.VisibleEntity;

/**
 * Created by pere5 on 02/01/16.
 */
public class Household extends RuleHelper {

    private static final int NEIGHBORHOOD_ZONE = 120;

    public Household(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        Home myHome = me.getHome();
        if (myHome.exists()) {
            int result = 0;
            for (VisibleEntity visibleEntity: getHomes()) {
                Home home = (Home)visibleEntity;
                int range = home != myHome ? range(home, myHome): Integer.MAX_VALUE;
                if (range < NEIGHBORHOOD_ZONE) {
                    result += 1;
                }
            }
            return result;
        } else {
            return 0;
        }
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
