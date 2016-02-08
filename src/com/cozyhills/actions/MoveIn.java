package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.buildings.Home;
import com.cozyhills.things.Person;

/**
 * Created by pere5 on 30/01/16.
 */
public class MoveIn extends Action {
    Home home;

    public MoveIn(Home home) {
        this.home = home;
    }

    @Override
    public boolean doIt(Person me) {
        if (closeEnough(me.xy, home.xy)) {
            home.moveIn(me);
            return DONE;
        } else {
            Util.printPerIsStupidMessage("MoveIn.doIt()");
            return DONE;
        }
    }
}
