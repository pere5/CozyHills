package com.cozyhills.rules;

import com.cozyhills.Const;
import com.cozyhills.actions.*;
import com.cozyhills.cozy.Util;
import com.cozyhills.rules.RuleHelper;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.BasicHut;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.items.Item;
import com.cozyhills.things.resources.Resource;

import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 * Created by pere5 on 02/01/16.
 */
public class ImproveHome extends RuleHelper {

    public ImproveHome(int rank) {
        super(rank);
    }

    @Override
    public int calculateStatus(Person me) {
        Optional<Home> myHome = me.getHome();
        if (myHome.isPresent() && myHome.get().completed()) {
            int result = 0;
            for (Home home: getHomes()) {
                double range = range(home, myHome.get()); //include my own home
                if (range < Const.NEIGHBORHOOD_ZONE) {
                    result += home.getStatus();
                }
            }
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public void initWork(Person me, int status) {
        Queue<Action> actionQueue = me.getActionQueue();
        //Util.printNotImplemented("Household.improveExistingHome()");
        actionQueue.add(new Wait(10));
    }
}
