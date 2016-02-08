package com.cozyhills.actions;

import com.cozyhills.things.Person;

/**
 * Created by pere5 on 07/02/16.
 */
public class DropCarrying extends Action {
    @Override
    public boolean doIt(Person me) {
        me.dropCarrying();
        return DONE;
    }
}
