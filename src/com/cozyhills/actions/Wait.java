package com.cozyhills.actions;

import com.cozyhills.cozy.Util;
import com.cozyhills.things.Person;

/**
 * Created by pere5 on 14/01/16.
 */
public class Wait extends Action {

    private int wait;
    private final int id = 1;

    public Wait(int frames) {
        wait = frames;
    }

    @Override
    public boolean doIt(Person me) {
        Util.printActionId(id);
        wait--;
        return wait > 0;
    }
}
