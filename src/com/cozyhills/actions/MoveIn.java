package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;
import com.cozyhills.things.buildings.Home;

/**
 * Created by pere5 on 30/01/16.
 */
public class MoveIn extends Action {
    private final Home home;
    private final int id = 4;

    public MoveIn(Home home) {
        this.home = home;
    }

    @Override
    public boolean doIt(Person me) {
        Util.printActionId(id);
        if (closeEnough(me.xy, home.xy, Path.STEP)) {
            home.moveIn(me);
            me.visited(home);
            return DONE;
        } else {
            Util.printPerIsStupidMessage("MoveIn.doIt()");
            return DONE;
        }
    }
}
