package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;

/**
 * Created by pere5 on 07/02/16.
 */
public class DropCarrying extends Action {

    private final int id = 6;

    @Override
    public boolean doIt(Person me) {
        Util.printActionId(id);
        me.dropCarrying();
        return DONE;
    }
}
